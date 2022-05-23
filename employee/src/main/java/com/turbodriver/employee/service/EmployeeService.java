package com.turbodriver.employee.service;

import com.turbodriver.clients.carfleet.CarGetDto;
import com.turbodriver.employee.exposition.dto.EmployeeRegistrationRequest;
import com.turbodriver.employee.model.Employee;

import java.text.ParseException;

public interface EmployeeService {
    void registerEmployee(EmployeeRegistrationRequest request);
    Employee getEmployee(String id);
    CarGetDto checkDriverCarData(String id);
    Boolean isCarInConformity(String driverId) throws ParseException;
}
