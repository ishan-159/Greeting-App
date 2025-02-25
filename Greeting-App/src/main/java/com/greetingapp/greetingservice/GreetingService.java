package com.greetingapp.greetingservice;

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
}
