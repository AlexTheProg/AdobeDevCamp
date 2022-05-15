package com.turbodriver.clients.carfleet;

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
    public String literPer100Km;
    public String acquisitionDate;
}
