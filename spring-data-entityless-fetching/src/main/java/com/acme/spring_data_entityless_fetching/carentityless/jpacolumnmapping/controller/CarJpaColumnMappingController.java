package com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping.controller;


import com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping.service.CarDto;
import com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping.service.CarJpaColumnMappingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jpa-column")
class CarJpaColumnMappingController {

    private final CarJpaColumnMappingService carJpaColumnMappingService;

    CarJpaColumnMappingController(CarJpaColumnMappingService carJpaColumnMappingService) {
        this.carJpaColumnMappingService = carJpaColumnMappingService;
    }

    @GetMapping("/get-cars-after-years-named/{years}")
    List<CarDto> getTotalCarsByModelNamed(@PathVariable Integer years) {
        return carJpaColumnMappingService.findCarsAfterYearsNamed(years);
    }

    @GetMapping("/get-cars-after-years-native/{years}")
    List<CarDto> getTotalCarsByModelNative(@PathVariable Integer years) {
        return carJpaColumnMappingService.findCarsAfterYearsNative(years);
    }
}
