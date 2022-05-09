package com.turbodriver.carfleet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Branch {

    @Id
    @SequenceGenerator(
            name = "branch_id_sequence",
            sequenceName = "branch_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "branch_id_sequence"
    )
    private Integer branchId;
    private String city;
    private String country;

    @OneToOne(mappedBy = "branch")
    private CarFleet carFleet;
}
