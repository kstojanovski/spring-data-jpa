package com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping;

import com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping.persistence.CarFetcherModel;
import com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping.persistence.CarJpaColumnMappingRepository;
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
@Import(CarJpaColumnMappingRepository.class)
public class CarDataJpaTest {

   @Container
   @ServiceConnection
   static MSSQLServerContainer<?> mssqlServerContainer =
       new MSSQLServerContainer<>(DockerImageName.parse("mcr.microsoft.com/mssql/server:2022-CU18-ubuntu-22.04"))
           .acceptLicense();

   @Autowired
   CarJpaColumnMappingRepository carJpaColumnMappingRepository;

   @Test
   void testGetCarsAfterYearsNamed() {
      // Act
      List<CarFetcherModel> carsAfterYear = carJpaColumnMappingRepository.findCarsAfterYearsNamed(1980);

      // Assert
      ListAssert<CarFetcherModel> carEntityListAssert = Assertions.assertThat(carsAfterYear);
      carEntityListAssert.isNotNull();
      carEntityListAssert.isNotEmpty();
      carEntityListAssert.hasSize(5);
   }

   @Test
   void testGetCarsAfterYearsNative() {
      // Act
      List<CarFetcherModel> carsAfterYear = carJpaColumnMappingRepository.findCarsAfterYearsNative(1980);

      // Assert
      ListAssert<CarFetcherModel> carEntityListAssert = Assertions.assertThat(carsAfterYear);
      carEntityListAssert.isNotNull();
      carEntityListAssert.hasSize(5);
      carEntityListAssert.isNotEmpty();
   }

}
