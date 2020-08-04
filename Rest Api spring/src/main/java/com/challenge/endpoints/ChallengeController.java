package com.challenge.endpoints;

import com.challenge.entity.Challenge;
import com.challenge.service.impl.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/challenge")
public class ChallengeController {
    @Autowired
    ChallengeService challengeService;

    @GetMapping
    public List<Challenge> findByAccelerationIdAndUserId(
            @RequestParam(value = "accelerationId") Long accelerationId,
            @RequestParam(value = "userId") Long userId) {
        return challengeService.findByAccelerationIdAndUserId(accelerationId, userId);
    }

}
