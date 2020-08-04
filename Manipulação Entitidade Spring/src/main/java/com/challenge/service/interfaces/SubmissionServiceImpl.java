package com.challenge.service.interfaces;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@Service
public class SubmissionServiceImpl implements SubmissionServiceInterface {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        BigDecimal result = submissionRepository.findHigherScoreByChallengeId(challengeId);
        if (result != null)
        {
            return result;
        }
        return BigDecimal.ZERO;
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return submissionRepository.findByChallegeIdAndAccelerationId(challengeId, accelerationId);
    }

    @Override
    public Submission save(Submission object) {
        return submissionRepository.save(object);
    }
}
