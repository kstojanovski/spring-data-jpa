package com.acme.spring_data_entityless_fetching.carentityless.jdbcmapping.persistence;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDtoRowMapper implements RowMapper<CarDto> {

    @Override
    public CarDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CarDto(
            rs.getInt("id"),
            rs.getString("model"),
            rs.getInt("year"),
            rs.getString("brand")
        );
    }
}
