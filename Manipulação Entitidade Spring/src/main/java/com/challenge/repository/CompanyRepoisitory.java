package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CompanyRepoisitory extends CrudRepository<Company, Long> {
    Optional<Company> findById(Long Id);
    @Query(value = "select distinct co.* from company co " +
            "INNER JOIN candidate ca " +
            "ON co.id = ca.company_id " +
            "where ca.acceleration_id = :accelerationId", nativeQuery = true)
    List<Company> findbyAccelerationId(Long accelerationId);
    @Query(value = "select * from company co " +
            "INNER JOIN  candidate ca " +
            "ON co.id = ca.company_id " +
            "where ca.user_id = :userId", nativeQuery = true)
    List<Company> findByUserId(Long userId);
    Company save(Company company);
}
