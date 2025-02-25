package com.greetingapp;

import com.greetingapp.greetingservice.GreetingService;
import com.greetingapp.model.Greetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    //UC3 && UC4
    @GetMapping("/personalized")
    public String getPersonalizedGreeting(@RequestParam(required = false) String firstName,
                                          @RequestParam(required = false) String lastName) {
        Greetings savedGreeting = greetingService.saveGreeting(firstName,lastName);
        return  greetingService.getPersonalizedGreeting(firstName, lastName) ;
    }

    //UC5
    @GetMapping("/{id}")
    public ResponseEntity<Greetings> getGreetingById(@PathVariable Long id) {
        Greetings greeting = greetingService.getGreetingById(id);
        return ResponseEntity.ok(greeting);
    }
    //UC6
    @GetMapping("/all")
    public ResponseEntity<List<Greetings>> getAllGreetings() {
        List<Greetings> greeting = greetingService.getAllGreetings();
        return ResponseEntity.ok(greeting);
    }
}
