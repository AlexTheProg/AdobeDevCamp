package com.turbodriver.carfleet.service.car;

import com.turbodriver.carfleet.model.Car;
import com.turbodriver.carfleet.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{

    private final CarRepository carRepo;

    @Override
    @Transactional
    public Car addCar(Car newCar) {
        newCar.setAcquisitionDate(Date.from(Instant.now()));
        newCar.setFabricationDate(LocalDateTime.from(LocalDateTime.now()));
        return carRepo.save(newCar);
    }

    @Override
    public void deleteCar(String id) {
        Car car = carRepo.findByCarId(Integer.parseInt(id)).orElseThrow(UnknownError::new);
        carRepo.delete(car);
    }

    @Override
    public Car updateCar(Car updateCar) {
        Car newCar = Car.builder()
                .carId(updateCar.getCarId())
                .carFleet(updateCar.getCarFleet())
                .driverId(updateCar.getDriverId())
                .carMake(updateCar.getCarMake())
                .carModel(updateCar.getCarModel())
                .acquisitionDate(Date.from(Instant.now()))
                .fabricationDate(LocalDateTime.from(LocalDateTime.now()))
                .literPer100Km(updateCar.getLiterPer100Km())
                .build();
        return carRepo.save(newCar);
    }

    @Override
    public Car findCarByDriverId(String driverId) {
        return carRepo.findByDriverId(Integer.parseInt(driverId)).orElseThrow(UnknownError::new);
    }
}
