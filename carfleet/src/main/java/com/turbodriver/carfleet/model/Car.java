package com.turbodriver.carfleet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;


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
    private String carModel;
    private LocalDateTime fabricationDate;
    private Double literPer100Km;
    private LocalDateTime acquisitionDate;

    @ManyToOne
    @JoinColumn(name = "carFleetId")
    private CarFleet carFleet;

}
