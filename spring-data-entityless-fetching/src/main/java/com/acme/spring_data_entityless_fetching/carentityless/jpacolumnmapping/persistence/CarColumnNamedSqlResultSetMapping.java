package com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping.persistence;


import jakarta.persistence.*;

@SqlResultSetMapping(
    name="CustomCarColumnNamedMapping",
    classes={
        @ConstructorResult(
            targetClass= CarFetcherModel.class,
            columns={
                @ColumnResult(name="id", type=Integer.class),
                @ColumnResult(name="model", type=String.class),
                @ColumnResult(name="year", type=Integer.class),
                @ColumnResult(name="brand", type=String.class)
            }
        )
    }
)
@NamedNativeQuery(
        name = "CarColumnNamedSqlResultSetMapping.findCarsAfterYears",
        query = "EXEC FIND_CARS_AFTER_YEAR @year_in = :yearParam;",
        resultSetMapping = "CustomCarColumnNamedMapping"
)
@Entity
public class CarColumnNamedSqlResultSetMapping {

   @Id
   int id;
}
