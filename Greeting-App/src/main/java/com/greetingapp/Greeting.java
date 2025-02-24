package com.greetingapp;

public class Greeting {
    private String message;
    private String method;
    public Greeting(String message, String method) {
        this.message = message;
        this.method = method;
    }

    public String getMessage() {
        return message;
    }

    public String getMethod() {
        return method;
    }
}
