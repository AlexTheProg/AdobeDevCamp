package com.turbodriver.employee.exposition.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class EmployeeRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String hiringDate;
    private String dateOfBirth;
    private String jobTitle;
    private String salary;

}
