package com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping.persistence;


public record CarFetcherModel(
    Integer id,
    String model,
    Integer year,
    String brand
) {
}
