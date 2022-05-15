package com.turbodriver.clients.carfleet;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("carfleet")
public interface CarFleetClient {

    @GetMapping("api/v1/cars/{driverId}")
    CarGetDto getCarByDriver(@PathVariable("driverId") String driverId);

}
