package com.hazelcast.caching.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/hazelcast")
@RestController
public class HazelcastController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HazelcastController.class);

    @GetMapping("test")
    public String test() {
        return "Working";
    }

}
