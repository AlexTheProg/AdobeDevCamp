package com.turbodriver.carfleet.exposition.mapper.car;

import com.turbodriver.carfleet.exposition.dto.car.CarGetDto;
import com.turbodriver.carfleet.exposition.dto.car.CarPostDto;
import com.turbodriver.carfleet.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarGetDto mapFromDomain(Car car);
    Car mapToDomain(CarGetDto carDto);

    Car mapCarPostDtoToDomain(CarPostDto request);
}
