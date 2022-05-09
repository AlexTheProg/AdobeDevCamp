package com.turbodriver.carfleet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @SequenceGenerator(
            name = "car_id_sequence",
            sequenceName = "car_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_id_sequence"
    )
    private Integer carId;
    private Integer driverId;
    private String carMake;
    private String model;
    private Date fabricationDate;
    private Double literPer100Km;
    private Date acquisitionDate;

    @ManyToOne
    @JoinColumn(name = "carFleetId", nullable = false)
    private CarFleet carFleet;

}
