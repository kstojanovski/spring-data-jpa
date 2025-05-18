package com.acme.spring_data_entityless_fetching.carentityless.jpacolumnmapping.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarJpaColumnMappingRepository {

    @PersistenceContext
    EntityManager entityManager;


    public List<CarFetcherModel> findCarsAfterYearsNative(int year) {
        Query findCarsAfterYearsNativedQuery = entityManager
            .createNativeQuery(
                "EXEC FIND_CARS_AFTER_YEAR @year_in = :yearParam;",
                "CustomCarColumnMapping"
            );
        findCarsAfterYearsNativedQuery.setParameter("yearParam", year);
        return findCarsAfterYearsNativedQuery.getResultList();
    }

    public List<CarFetcherModel> findCarsAfterYearsNamed(int year) {
        TypedQuery<CarFetcherModel> findCarsAfterYearsNamedQuery = entityManager
            .createNamedQuery(
                "CarColumnNamedSqlResultSetMapping.findCarsAfterYears",
                CarFetcherModel.class
            );
        findCarsAfterYearsNamedQuery.setParameter("yearParam", year);
        return findCarsAfterYearsNamedQuery.getResultList();
    }
}
