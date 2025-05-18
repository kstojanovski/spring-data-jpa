package com.acme.spring_data_entityless_fetching.carentityless.jdbcmapping.service;

import com.acme.spring_data_entityless_fetching.carentityless.jdbcmapping.persistence.CarDto;
import com.acme.spring_data_entityless_fetching.carentityless.jdbcmapping.persistence.CarJdbcMappingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarJdbcMappingService {

    private final CarJdbcMappingRepository carJdbcMappingRepository;

    public CarJdbcMappingService(CarJdbcMappingRepository carJdbcMappingRepository) {
        this.carJdbcMappingRepository = carJdbcMappingRepository;
    }

    public List<CarDto> findCarsAfterYearsTemplate(int year) {
        return carJdbcMappingRepository.findCarsAfterYearsTemplate(year);
    }

    public CarDto findCarsAfterYearsClient(int year, int carId) {
        return findCarsAfterYearsClient(year)
                .stream()
                .filter(car -> car.carId() == carId)
                .findFirst()
                .orElse(null);
    }

    public List<CarDto> findCarsAfterYearsClient(int year) {
        return carJdbcMappingRepository.findCarsAfterYearsClient(year);
    }
}
