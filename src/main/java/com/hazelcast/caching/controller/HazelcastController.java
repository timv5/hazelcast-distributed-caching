package com.hazelcast.caching.controller;

import com.hazelcast.caching.model.Users;
import com.hazelcast.caching.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/hazelcast")
@RestController
public class HazelcastController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HazelcastController.class);

    private final UserServiceImpl userService;

     @Autowired
    public HazelcastController(final UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Users getUserById(@RequestParam final Long id) {
            LOGGER.info("::: HazelcastController.getUserById :::");
         return this.userService.getUser(id).get();
    }

    @PostMapping("/user")
    public Users saveUser(Users user) {
        LOGGER.info("::: HazelcastController.saveUser :::");
         return this.userService.save(user);
    }

    @DeleteMapping
    public Users deleteUser(Users user) {
        LOGGER.info("::: HazelcastController.deleteUser :::");
         return this.userService.deleteUser(user);
    }

}
