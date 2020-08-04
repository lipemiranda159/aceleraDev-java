package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {
    @Query(value = "select * from candidate "+
    "where company_id = :companyId", nativeQuery = true)
    List<Candidate> findByCompanyId(Long companyId);
    @Query(value = "select * from candidate "+
            "where acceleration_id = :accelerationId", nativeQuery = true)
    List<Candidate> findByAccelerationId(Long accelerationId);
    Candidate save(Candidate acceleration);

}
