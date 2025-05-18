package com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping.service;

import com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping.persistence.CarFetcherModel;
import com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping.persistence.CarJpaColumnMappingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarJpaColumnMappingService {

    private final CarJpaColumnMappingRepository carJpaColumnMappingRepository;

    public CarJpaColumnMappingService(CarJpaColumnMappingRepository carJpaColumnMappingRepository) {
        this.carJpaColumnMappingRepository = carJpaColumnMappingRepository;
    }

    public List<CarDto> findCarsAfterYearsNamed(int year) {
        return fetcherToDto(carJpaColumnMappingRepository.findCarsAfterYearsNamed(year));
    }

    public List<CarDto> findCarsAfterYearsNative(int year) {
        return fetcherToDto(carJpaColumnMappingRepository.findCarsAfterYearsNative(year));
    }

    private List<CarDto> fetcherToDto (List<CarFetcherModel> cars) {
        return cars.stream()
                .map(car -> new CarDto(
                        car.id(),
                        car.model(),
                        car.year(),
                        car.brand()
                ))
                .collect(Collectors.toList());
    }
}
