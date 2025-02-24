package com.greetingapp;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
 public  class GreetingController {
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
}
