package com.greetingapp.greetingservice;

import com.greetingapp.model.Greetings;
import com.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
