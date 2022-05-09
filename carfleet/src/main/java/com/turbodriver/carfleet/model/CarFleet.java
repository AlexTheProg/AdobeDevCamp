package com.turbodriver.carfleet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class CarFleet {

    @Id
    @SequenceGenerator(
            name = "car_fleet_id_sequence",
            sequenceName = "car_fleet_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_fleet_id_sequence"
    )
    private Integer carFleetId;


    @OneToOne
    @JoinColumn(name = "branchId")
    private Branch branch;


    @OneToMany(mappedBy = "carFleet")
    private Set<Car> carSet;
}
