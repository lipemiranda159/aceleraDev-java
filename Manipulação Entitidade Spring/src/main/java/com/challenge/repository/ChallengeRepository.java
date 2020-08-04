package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChallengeRepository extends CrudRepository<Challenge, Long> {
    @Query(value = "select * from challenge ch " +
            "INNER JOIN  submission su " +
            "ON ch.id = su.challenge_id " +
            "INNER JOIN acceleration acc "+
            "ON ch.id = acc.challenge_id "+
            "where acc.id = :accelerationId "+
            "and su.user_id = :userId", nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId);
    Challenge save(Challenge challenge);
}
