package com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping.service;

public record CarDto(
    Integer carId,
    String carModel,
    Integer carCreationYear,
    String carBrand
) {
}
