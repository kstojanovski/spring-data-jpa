package com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping.persistence;


import jakarta.persistence.*;

@SqlResultSetMapping(
    name="CustomCarColumnMapping",
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
@Entity
public class CarColumnSqlResultSetMapping {

   @Id
   int id;
}
