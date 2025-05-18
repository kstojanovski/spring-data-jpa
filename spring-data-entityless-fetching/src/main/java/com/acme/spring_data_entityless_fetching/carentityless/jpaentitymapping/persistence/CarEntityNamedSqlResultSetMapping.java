package com.acme.spring_data_entityless_fetching.carentityless.jpaentitymapping.persistence;


import jakarta.persistence.*;

@SqlResultSetMapping(
    name="CustomCarEntityNamedMapping",
    entities = {
        @EntityResult(
            entityClass = CarFetcherModel.class,
            fields = {
                @FieldResult(name = "carId", column = "id"),
                @FieldResult(name = "carModel", column = "model"),
                @FieldResult(name = "carCreationYear", column = "year"),
                @FieldResult(name = "carBrand", column = "brand")
            }
        )
    }
)
@NamedNativeQuery(
    name = "CarEntityNamedSqlResultSetMapping.findCarsAfterYears",
    query = "EXEC FIND_CARS_AFTER_YEAR @year_in = :yearParam;",
    resultSetMapping = "CustomCarEntityNamedMapping"
)
@Entity
public class CarEntityNamedSqlResultSetMapping {

   @Id
   int id;
}
