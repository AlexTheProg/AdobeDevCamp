package com.turbodriver.employee.service;

import com.turbodriver.employee.exception.UserAlreadyExists;
import com.turbodriver.employee.exception.UserNotFound;
import com.turbodriver.employee.exposition.dto.CarGetResponse;
import com.turbodriver.employee.exposition.dto.EmployeeRegistrationRequest;
import com.turbodriver.employee.model.Employee;
import com.turbodriver.employee.model.Job;
import com.turbodriver.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final RestTemplate restTemplate;

    @Override
    public void registerEmployee(EmployeeRegistrationRequest request) {
        Employee employee = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .dateOfBirth(Date.from(Instant.now()))
                .hiringDate(Date.from(Instant.now()))
                .jobTitle(Job.valueOf(request.getJobTitle()))
                .salary(BigDecimal.valueOf(1000))
                .build();
        //TODO: check if email is valid
        /*
        TODO: check if the employee is a driver. If he is a driver, check
              what his assigned car is and also check if it is still part of the car fleet
              that we have.
        LATER TODO: If is not part of the fleet, check if it meets the minimum requirements
                    and make an endpoint to make adding it possible, if the employee wishes to.
                    USE CASE: Registering personal car as a work car, so an employee will have
                    the posibility and responsibility to use his own car, sort of like a contractor
                    instead of a regular employee.
        * */
        if(employeeRepo.findByEmail(request.getEmail()).isPresent()){
            throw new UserAlreadyExists();
        }
        employeeRepo.save(employee);
    }



    @Override
    public Employee getEmployee(String id) {
        return employeeRepo.findById(Integer.parseInt(id)).orElseThrow(UserNotFound::new);
    }

    @Override
    public CarGetResponse checkDriverCarData(String id) {
        Employee employee = employeeRepo
                .findById(Integer.parseInt(id))
                .orElseThrow(UserNotFound::new);
        return restTemplate.getForObject(
                "http://CARFLEET/api/v1/cars/{driverId}",
                CarGetResponse.class,
                id
        );
    }

}
