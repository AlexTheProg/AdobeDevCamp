package com.turbodriver.employee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_id_sequence",
            sequenceName = "employee_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_id_sequence"
    )
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Date hiringDate;
    private Date dateOfBirth;
    private BigDecimal salary;
    @Enumerated(EnumType.STRING)
    private Job jobTitle;
    private Boolean isManager;
}
