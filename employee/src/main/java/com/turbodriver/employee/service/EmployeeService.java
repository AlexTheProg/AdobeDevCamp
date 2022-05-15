package com.turbodriver.employee.service;

import com.turbodriver.employee.exposition.dto.CarGetResponse;
import com.turbodriver.employee.exposition.dto.EmployeeRegistrationRequest;
import com.turbodriver.employee.model.Employee;

public interface EmployeeService {
    void registerEmployee(EmployeeRegistrationRequest request);
    Employee getEmployee(String id);
    CarGetResponse checkDriverCarData(String id);
}
