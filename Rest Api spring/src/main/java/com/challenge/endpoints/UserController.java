package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id).get();
    }
    @GetMapping(params = "accelerationName")
    public Iterable<User> findByAccelerationName(@RequestParam(name = "accelerationName") String accelerationName) {
        return userService.findByAccelerationName(accelerationName);
    }

    @GetMapping(params = "companyId")
    public Iterable<User> findByCompanyId(@RequestParam(name ="companyId") Long companyId) {
        return userService.findByCompanyId(companyId);
    }

}
