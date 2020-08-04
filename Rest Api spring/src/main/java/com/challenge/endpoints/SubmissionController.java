package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.dto.SubmissionDTO;
import com.challenge.entity.Candidate;
import com.challenge.entity.Submission;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.impl.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/submission")
@RequiredArgsConstructor
public class SubmissionController {

    @Autowired
    SubmissionService submissionService;
    @Autowired
    SubmissionMapper submissionMapper;

    @GetMapping
    public ResponseEntity<List<SubmissionDTO>> findByChallengeIdAndAccelerationId(
            @RequestParam(required = true, value = "challengeId") Long challengeId,
            @RequestParam(required = true, value = "accelerationId") Long accelerationId) {
        return MapResponseList(submissionService.findByChallengeIdAndAccelerationId(challengeId, accelerationId));

    }

    private ResponseEntity<List<SubmissionDTO>> MapResponseList(List<Submission> submissions)
    {
        return ResponseEntity.ok(submissionMapper.map(submissions));
    }

    private ResponseEntity<SubmissionDTO> MapResponse(Optional<Submission> submission)
    {
        return submission.isPresent() ? ResponseEntity.ok(new SubmissionDTO())
                : ResponseEntity.ok(submissionMapper.map(submission.get()));
    }
}
