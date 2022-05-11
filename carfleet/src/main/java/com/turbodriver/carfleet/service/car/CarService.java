package com.turbodriver.carfleet.service.car;

import com.turbodriver.carfleet.model.Car;

public interface CarService {
    Car addCar(Car newCar);
    void deleteCar(String id);
    Car updateCar(Car updateCar);
    Car findCarByDriverId(String driverId);
}
