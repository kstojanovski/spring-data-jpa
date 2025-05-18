package com.acme.spring_data_entityless_fetching.carentityless.jpaentitymapping.service;

import com.acme.spring_data_entityless_fetching.carentityless.jpaentitymapping.persistence.CarFetcherModel;
import com.acme.spring_data_entityless_fetching.carentityless.jpaentitymapping.persistence.CarJpaEntityMappingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarJpaEntityMappingService {

    private final CarJpaEntityMappingRepository carRepositoryJpaEntityMapping;

    public CarJpaEntityMappingService(CarJpaEntityMappingRepository carRepositoryJpaEntityMapping) {
        this.carRepositoryJpaEntityMapping = carRepositoryJpaEntityMapping;
    }

    public List<CarFetcherModel> findCarsAfterYearsNamed(int year) {
        return carRepositoryJpaEntityMapping.findCarsAfterYearsNamed(year);
    }

    public List<CarFetcherModel> findCarsAfterYearsNative(int year) {
        return carRepositoryJpaEntityMapping.findCarsAfterYearsNative(year);
    }
}
