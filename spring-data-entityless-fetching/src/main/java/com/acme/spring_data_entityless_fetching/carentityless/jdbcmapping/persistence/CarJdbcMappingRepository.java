package com.acme.spring_data_entityless_fetching.carentityless.jdbcmapping.persistence;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarJdbcMappingRepository {

    private final JdbcClient jdbcClient;
    private final NamedParameterJdbcTemplate jbcTemplate;

    public CarJdbcMappingRepository(NamedParameterJdbcTemplate jdbcTemplate, JdbcClient jdbcClient) {
        this.jbcTemplate = jdbcTemplate;
        this.jdbcClient = jdbcClient;
    }

    public List<CarDto> findCarsAfterYearsTemplate(int year) {
        return jbcTemplate.query(
            "EXEC FIND_CARS_AFTER_YEAR @year_in = :yearParam;",
            new MapSqlParameterSource("yearParam", year),
            new CarDtoRowMapper()
        );
    }

    public List<CarDto> findCarsAfterYearsClient(int year) {
        return jdbcClient.sql("EXEC FIND_CARS_AFTER_YEAR @year_in = :yearParam;")
            .param("yearParam", year)
            .query(new CarDtoRowMapper()).list();
    }

}
