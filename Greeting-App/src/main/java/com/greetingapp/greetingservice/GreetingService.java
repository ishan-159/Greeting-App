package com.greetingapp.greetingservice;

import com.greetingapp.model.Greetings;
import com.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {


    //UC2
    public String getGreetingMessage() {
        return "Hello World";
    }

    //UC3
    public String getPersonalizedGreeting(String firstName, String lastName) {
        if(firstName != null && lastName != null  ) {
            return "Hello " + firstName + " " + lastName;
        } else if (firstName != null) {
            return "Hello " + firstName;
        } else if (lastName != null) {
            return "Hello " + lastName;
        } else {
            return "Hello World";
        }
    }
    //UC4
    private final GreetingRepository greetingRepository;

    @Autowired
    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }
    public Greetings saveGreeting(String firstName, String lastName) {
        String message = getPersonalizedGreeting(firstName, lastName);
        Greetings greeting = new Greetings(message);
        return greetingRepository.save(greeting);
    }
    //UC5
    public Greetings getGreetingById(Long id){
        return greetingRepository.findById(id).orElseThrow(() ->new RuntimeException("Greeting not found ID : " + id));
    }
    //UC6
    public List<Greetings> getAllGreetings() {
        return greetingRepository.findAll();
    }
    //UC7
    public Greetings updateGreeting(Long id, String newMessage) {
        Greetings existingGreeting = greetingRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found with ID : " + id));

        existingGreeting.setMessage(newMessage);
        return greetingRepository.save(existingGreeting);
    }
    public void deleteGreeting(Long id) {
        Greetings existingGreeting = greetingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found with ID : " + id));
        greetingRepository.delete(existingGreeting);
    }
}

