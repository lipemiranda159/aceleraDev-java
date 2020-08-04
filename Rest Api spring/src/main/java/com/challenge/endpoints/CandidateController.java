package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public ResponseEntity<CandidateDTO> findCandidate(@PathVariable("userId") Long userId,
                                                      @PathVariable("companyId") Long companyId,
                                                      @PathVariable("accelerationId") Long accelerationId) {
        Optional<Candidate> candidate = this.candidateService.findById(userId, companyId, accelerationId);
        return MapResponse(candidate);
    }

    @GetMapping(params = "companyId")
    public ResponseEntity<List<CandidateDTO>> findByCompanyId(@RequestParam(name = "companyId") Long companyId) {
        return MapResponseList(candidateService.findByCompanyId(companyId));
    }

    @GetMapping(params = "accelerationId")
    public ResponseEntity<List<CandidateDTO>> findByAccelerationId(@RequestParam(name = "accelerationId") Long accelerationId) {
        return MapResponseList(candidateService.findByAccelerationId(accelerationId));
    }

    private ResponseEntity<List<CandidateDTO>> MapResponseList(List<Candidate> candidates)
    {
        return ResponseEntity.ok(candidateMapper.map(candidates));
    }

    private ResponseEntity<CandidateDTO> MapResponse(Optional<Candidate> candidate)
    {
        return candidate.map(value ->
                ResponseEntity.ok(this.candidateMapper.map(value))).orElseGet(() ->
                ResponseEntity.ok(new CandidateDTO()));
    }

}
