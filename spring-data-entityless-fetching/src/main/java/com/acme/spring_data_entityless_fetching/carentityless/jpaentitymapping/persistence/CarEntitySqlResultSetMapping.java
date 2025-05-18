package com.acme.spring_data_entityless_fetching.carentityless.jpaentitymapping.persistence;


import jakarta.persistence.*;

@SqlResultSetMapping(
    name="CustomCarEntityMapping",
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
@Entity
public class CarEntitySqlResultSetMapping {

   @Id
   int id;
}
