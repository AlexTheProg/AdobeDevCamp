package com.turbodriver.carfleet.repository;

import com.turbodriver.carfleet.model.CarFleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarFleetRepository extends JpaRepository<CarFleet, Integer> {
}
