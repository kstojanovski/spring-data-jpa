package com.acme.spring_data_entityless_fetching.carentityless.jpaentitymapping.controller;


import com.acme.spring_data_entityless_fetching.carentityless.jpaentitymapping.persistence.CarFetcherModel;
import com.acme.spring_data_entityless_fetching.carentityless.jpaentitymapping.service.CarJpaEntityMappingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jpa-entity")
class CarJpaEntityMappingController {

    private final CarJpaEntityMappingService carJpaEntityMappingService;

    CarJpaEntityMappingController(CarJpaEntityMappingService carJpaEntityMappingService) {
        this.carJpaEntityMappingService = carJpaEntityMappingService;
    }

    @GetMapping("/get-cars-after-years-named/{years}")
    List<CarFetcherModel> getTotalCarsByModelNamed(@PathVariable Integer years) {
        return carJpaEntityMappingService.findCarsAfterYearsNamed(years);
    }

    @GetMapping("/get-cars-after-years-native/{years}")
    List<CarFetcherModel> getTotalCarsByModelNative(@PathVariable Integer years) {
        return carJpaEntityMappingService.findCarsAfterYearsNative(years);
    }
}
