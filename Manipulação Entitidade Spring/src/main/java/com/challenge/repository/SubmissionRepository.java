package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {
    @Query(value= "select max(score) from submission "+
    "where challenge_id = :challengeId",nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(Long challengeId);
    @Query(value= "select su.* from submission su "+
            "INNER JOIN challenge ch "+
            "ON su.challenge_id = ch.Id "+
            "INNER JOIN acceleration acc "+
            "ON ch.Id = acc.challenge_id "+
            "where su.challenge_id = :challengeId "+
            "and acc.Id = :accelerationId",nativeQuery = true)
    List<Submission> findByChallegeIdAndAccelerationId(Long challengeId, Long accelerationId);
    Submission save(Submission submission);
}
