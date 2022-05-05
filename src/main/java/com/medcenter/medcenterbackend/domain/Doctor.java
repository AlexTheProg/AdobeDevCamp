package com.medcenter.medcenterbackend.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class Doctor extends Staff {
    private Integer id;
    private StaffType type;
    private String specialization;
    private String description;

    @Builder
    public Doctor(Integer id, StaffType type, String specialization, String description,
                  Date hiringDate, Double vacationDays, Long salary, Integer age) {
        this.id = id;
        this.type = type;
        this.specialization = specialization;
        this.description = description;
        this.hiringDate = hiringDate;
        this.vacationDays = vacationDays;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String getStaffType() {
        return String.format("The employee is a %s", type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id.equals(doctor.id) && type == doctor.type && specialization.equals(doctor.specialization) && description.equals(doctor.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, specialization, description);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", type=" + type +
                ", specialization='" + specialization + '\'' +
                ", description='" + description + '\'' +
                ", hiringDate=" + hiringDate +
                ", vacationDays=" + vacationDays +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
