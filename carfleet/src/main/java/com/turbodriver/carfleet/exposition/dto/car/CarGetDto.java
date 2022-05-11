package com.turbodriver.carfleet.exposition.dto.car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CarGetDto {
    public String carId;
    public String driverId;
    public String carMake;
    public String carModel;
    public String fabricationDate;
    private String literPer100Km;
    private String acquisitionDate;
}
