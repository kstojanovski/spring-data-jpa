package com.acme.spring_data_entityless_fetching.carentityless.jdbcmapping;

import com.acme.spring_data_entityless_fetching.carentityless.jdbcmapping.persistence.CarDto;
import com.acme.spring_data_entityless_fetching.carentityless.jdbcmapping.persistence.CarJdbcMappingRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

@Testcontainers
@DataJpaTest
@Import(CarJdbcMappingRepository.class)
public class CarJdbcMappingDataJpaTest {

   @Container
   @ServiceConnection
   static MSSQLServerContainer<?> mssqlServerContainer =
       new MSSQLServerContainer<>(DockerImageName.parse("mcr.microsoft.com/mssql/server:2022-CU18-ubuntu-22.04"))
           .acceptLicense();

   @Autowired
   CarJdbcMappingRepository carJdbcMappingRepository;

   @Test
   void testGetCarsAfterYearsTemplate() {
      // Act
      List<CarDto> carsAfterYear = carJdbcMappingRepository.findCarsAfterYearsTemplate(1980);

      // Assert
      ListAssert<CarDto> carEntityListAssert = Assertions.assertThat(carsAfterYear);
      carEntityListAssert.isNotNull();
      carEntityListAssert.isNotEmpty();
      carEntityListAssert.hasSize(5);
   }

   @Test
   void testGetCarsAfterYearsClient() {
      // Act
      List<CarDto> carsAfterYear = carJdbcMappingRepository.findCarsAfterYearsClient(1980);

      // Assert
      ListAssert<CarDto> carEntityListAssert = Assertions.assertThat(carsAfterYear);
      carEntityListAssert.isNotNull();
      carEntityListAssert.hasSize(5);
      carEntityListAssert.isNotEmpty();
   }

}
