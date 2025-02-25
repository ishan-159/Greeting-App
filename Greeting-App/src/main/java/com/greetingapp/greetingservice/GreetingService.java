package com.greetingapp.greetingservice;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    //UC2
    public String getGreetingMessage() {
        return "Hello World";
    }
}
