package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long userId);
    @Query(value = "select * from users usr "+
    "INNER JOIN candidate ca "+
        "ON usr.Id = ca.user_id "+
    "INNER JOIN acceleration acc "+
        "ON ca.acceleration_id = acc.Id "+
    "where acc.name = :name", nativeQuery = true)
    List<User> findByAccelerationName(String name);

    @Query(value = "select * from users usr "+
            "INNER JOIN candidate ca "+
            "ON usr.Id = ca.user_id "+
            "where ca.company_id = :companyId",nativeQuery = true)
    List<User> findByCompanyId(Long companyId);
}
