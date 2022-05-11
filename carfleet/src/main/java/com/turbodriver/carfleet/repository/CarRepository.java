package com.turbodriver.carfleet.repository;

import com.turbodriver.carfleet.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> findByCarId(Integer id);
    Optional<Car> findByDriverId(Integer id);
}
