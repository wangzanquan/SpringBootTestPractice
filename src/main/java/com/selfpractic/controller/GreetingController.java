package com.selfpractic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    Greeting greeting;

    AtomicLong count = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name") String name) {

        greeting.setId(count.incrementAndGet());
        greeting.setContent("Hello, I am learning SpringBoot from " + name);

        return greeting;
    }

}
