package com.medcenter.medcenterbackend.domain;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
public abstract class Staff {
    protected Date hiringDate;
    protected Double vacationDays;
    protected Long salary;
    protected Integer age;

    public abstract String getStaffType();

}
