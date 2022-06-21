package com.turbodriver.employee.service;

import com.turbodriver.amqp.RabbitMQMessageProducer;
import com.turbodriver.clients.carfleet.CarFleetClient;
import com.turbodriver.clients.carfleet.CarGetDto;
import com.turbodriver.clients.notification.NotificationRequest;
import com.turbodriver.employee.exception.UserAlreadyExists;
import com.turbodriver.employee.exception.UserNotFound;
import com.turbodriver.employee.exposition.dto.EmployeeRegistrationRequest;
import com.turbodriver.employee.model.Employee;
import com.turbodriver.employee.model.Job;
import com.turbodriver.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final CarFleetClient carFleetClient;
    private final RabbitMQMessageProducer messageProducer;

    @Override
    public void registerEmployee(EmployeeRegistrationRequest request) {
        if(employeeRepo.findByEmail(request.getEmail()).isPresent()){
            throw new UserAlreadyExists();
        }

        Employee employee = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .dateOfBirth(Date.from(Instant.now()))
                .hiringDate(Date.from(Instant.now()))
                .jobTitle(Job.valueOf(request.getJobTitle()))
                .salary(BigDecimal.valueOf(1000))
                .build();

        employeeRepo.saveAndFlush(employee);

        NotificationRequest notificationRequest = new NotificationRequest(
                employee.getId(),
                employee.getEmail(),
                String.format("Hi %s, welcome to TurboDriver ", employee.getFirstName())
        );
        messageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }



    @Override
    public Employee getEmployee(String id) {
        return employeeRepo.findById(Integer.parseInt(id)).orElseThrow(UserNotFound::new);
    }

    @Override
    public CarGetDto checkDriverCarData(String id) {
        Employee employee = employeeRepo
                .findById(Integer.parseInt(id))
                .orElseThrow(UserNotFound::new);

        if(!employee.getJobTitle().equals(Job.DRIVER)){
            throw new RuntimeException("The employee is not a driver, he is a "
                    + employee.getJobTitle().getValue());
        }

        return carFleetClient.getCarByDriver(id);
    }

    @Override
    public Boolean isCarInConformity(String driverId) throws ParseException {
        CarGetDto carData = carFleetClient.getCarByDriver(driverId);
        LocalDateTime fabricationDate = LocalDateTime.parse(carData.getFabricationDate());
        return Math.abs(LocalDateTime.now().getYear() - fabricationDate.getYear()) <= 10;
    }


}
