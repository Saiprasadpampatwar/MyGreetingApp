package com.mygreetingapp.controller;

import com.mygreetingapp.model.Greeting;
import com.mygreetingapp.model.User;
import com.mygreetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    public static final String template = "Hello, %s!";
    public final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;

    @GetMapping({ "", "/", "/home" })
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    @RequestMapping("/id")
    public Greeting getId(@RequestParam(value = "id") long id) {
        return greetingService.getGreetingById(id);
    }


}
