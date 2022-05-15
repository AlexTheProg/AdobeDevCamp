package com.turbodriver.carfleet.exposition.controller;

import com.turbodriver.carfleet.exposition.dto.car.CarGetDto;
import com.turbodriver.carfleet.exposition.dto.car.CarPostDto;
import com.turbodriver.carfleet.exposition.mapper.car.CarMapper;
import com.turbodriver.carfleet.model.Car;
import com.turbodriver.carfleet.service.car.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarServiceImpl carService;
    private final CarMapper carMapper;

    @GetMapping("/{driverId}")
    public CarGetDto getCarByDriver(@PathVariable("driverId") String driverId){
        return carMapper.mapFromDomain(carService.findCarByDriverId(driverId));
    }

    @PostMapping()
    public ResponseEntity<Car> addCar(@RequestBody CarPostDto carPostDto){
        return ResponseEntity.ok(carService.addCar(carMapper.mapCarPostDtoToDomain(carPostDto)));
    }
}
