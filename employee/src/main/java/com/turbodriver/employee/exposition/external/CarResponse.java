package com.turbodriver.employee.exposition.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CarResponse {
    public String carId;
    public String carMake;
    public String carModel;
    public String fabricationDate;
    public String literPer100Km;
    public String acquisitionDate;

}
