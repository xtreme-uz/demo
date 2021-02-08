package com.example.demo.service.exception;

public class ObjectFieldRequiredException extends RuntimeException {

    public ObjectFieldRequiredException() {
    }

    public ObjectFieldRequiredException(String message) {
        super(message);
    }

    public ObjectFieldRequiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectFieldRequiredException(Throwable cause) {
        super(cause);
    }
}
