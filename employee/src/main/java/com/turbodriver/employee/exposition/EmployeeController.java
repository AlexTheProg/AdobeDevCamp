package com.turbodriver.employee.exposition;

import com.turbodriver.clients.carfleet.CarGetDto;
import com.turbodriver.employee.exposition.dto.CarGetResponse;
import com.turbodriver.employee.exposition.dto.EmployeeGetResponse;
import com.turbodriver.employee.exposition.dto.EmployeeMapper;
import com.turbodriver.employee.exposition.dto.EmployeeRegistrationRequest;
import com.turbodriver.employee.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@Slf4j
@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;
    private final EmployeeMapper mapper;

    @PostMapping
    public void registerEmployee(@RequestBody EmployeeRegistrationRequest employeeRegistrationRequest){
        log.info("new customer registration {}", employeeRegistrationRequest);
        employeeService.registerEmployee(employeeRegistrationRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeGetResponse> getEmployee(@PathVariable("id") String id){
        return ResponseEntity.ok(mapper.mapToGetDTO(employeeService.getEmployee(id)));
    }

    @GetMapping("/check-driver-car/{driverId}")
    public ResponseEntity<CarGetDto> getDriverCarData(@PathVariable("driverId") String id){
        return ResponseEntity.ok(employeeService.checkDriverCarData(id));
    }

    @GetMapping("/car-conformity/{driverId}")
    public ResponseEntity<?> checkCarIsValid(@PathVariable("driverId") String id) throws ParseException {
        return ResponseEntity.ok(employeeService.isCarInConformity(id));
    }
}
