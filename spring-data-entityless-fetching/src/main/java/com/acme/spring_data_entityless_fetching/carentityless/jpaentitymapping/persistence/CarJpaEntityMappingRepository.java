package com.acme.spring_data_entityless_fetching.carentityless.jpaentitymapping.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarJpaEntityMappingRepository {

    @PersistenceContext
    EntityManager entityManager;


    public List<CarFetcherModel> findCarsAfterYearsNative(int year) {
        Query findCarsAfterYearsNativedQuery = entityManager
            .createNativeQuery(
                "EXEC FIND_CARS_AFTER_YEAR @year_in = :yearParam;",
                "CustomCarEntityMapping"
            );
        findCarsAfterYearsNativedQuery.setParameter("yearParam", year);
        return findCarsAfterYearsNativedQuery.getResultList();
    }

    public List<CarFetcherModel> findCarsAfterYearsNamed(int year) {
        TypedQuery<CarFetcherModel> findCarsAfterYearsNamedQuery = entityManager
            .createNamedQuery(
                "CarEntityNamedSqlResultSetMapping.findCarsAfterYears",
                CarFetcherModel.class
            );
        findCarsAfterYearsNamedQuery.setParameter("yearParam", year);
        return findCarsAfterYearsNamedQuery.getResultList();
    }
}
