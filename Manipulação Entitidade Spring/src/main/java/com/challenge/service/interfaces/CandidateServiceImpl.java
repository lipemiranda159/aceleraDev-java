package com.challenge.service.interfaces;

import com.challenge.entity.*;
import com.challenge.repository.AccelerationRepository;
import com.challenge.repository.CandidateRepository;
import com.challenge.repository.CompanyRepoisitory;
import com.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CandidateServiceImpl implements CandidateServiceInterface {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Optional<Candidate> findById(CandidateId id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
        User user = new User();
        user.setId(userId);
        Acceleration acceleration = new Acceleration();
        acceleration.setId(accelerationId);
        Company company = new Company();
        company.setId(companyId);
        CandidateId id = new CandidateId(
                user,
                acceleration,
                company
        );
        return candidateRepository.findById(id);
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId) {
        return candidateRepository.findByCompanyId(companyId);
    }

    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        return candidateRepository.findByAccelerationId(accelerationId);
    }

    @Override
    public Candidate save(Candidate object) {
        return candidateRepository.save(object);
    }
}
