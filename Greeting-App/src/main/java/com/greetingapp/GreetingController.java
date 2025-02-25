package com.greetingapp;

import com.greetingapp.greetingservice.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello, World", "Get");
    }

    @PostMapping
    public Greeting postGreeting() {
        return new Greeting("Greeting Created", "Post");
    }

    @PutMapping
    public Greeting putGreeting() {
        return new Greeting("Greeting Updated", "Put");
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Greeting Deleted", "Delete");
    }

    //UC2
    private final GreetingService greetingService;
    @Autowired
    public GreetingController (GreetingService greetingService){
        this.greetingService = greetingService;
    }
    @GetMapping("/message")
    public String getGreetingMessage() {
        return greetingService.getGreetingMessage();
    }

}
