package com.acme.spring_data_entityless_fetching.carentityless.jdbcmapping.controller;

import com.acme.spring_data_entityless_fetching.carentityless.jdbcmapping.persistence.CarDto;
import com.acme.spring_data_entityless_fetching.carentityless.jdbcmapping.service.CarJdbcMappingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jdbc")
public class CarJdbcMappingController {

    private final CarJdbcMappingService carJdbcMappingService;

    public CarJdbcMappingController(
            CarJdbcMappingService carJdbcMappingService
    ) {
        this.carJdbcMappingService = carJdbcMappingService;
    }

    @GetMapping("/get-cars-after-years-template/{years}")
    List<CarDto> getTotalCarsByModelTemplate(@PathVariable Integer years) {
        return carJdbcMappingService.findCarsAfterYearsTemplate(years);
    }

    @GetMapping("/get-cars-after-years-client/{years}")
    List<CarDto> getTotalCarsByModelClient(@PathVariable Integer years) {
        return carJdbcMappingService.findCarsAfterYearsClient(years);
    }

}
