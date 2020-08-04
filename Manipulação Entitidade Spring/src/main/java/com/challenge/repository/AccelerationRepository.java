package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {
    Optional<Acceleration> findById(Long id);
    Optional<Acceleration> findByName(String name);
    @Query(value = "select * from acceleration acc " +
            "INNER JOIN  candidate ca " +
            "ON acc.id = ca.acceleration_id " +
            "where ca.company_id = :companyId", nativeQuery = true)
    List<Acceleration> findByCompanyId(Long companyId);
    Acceleration save(Acceleration acceleration);
}
