package com.turbodriver.employee.exposition.dto;

import com.turbodriver.employee.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeRegistrationRequest mapToDTO(Employee employee);

    Employee mapToDomain(EmployeeRegistrationRequest request);

    EmployeeGetResponse mapToGetDTO(Employee employee);
}
