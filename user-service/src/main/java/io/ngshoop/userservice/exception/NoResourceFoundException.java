package io.ngshoop.userservice.exception;

public class NoResourceFoundException extends RuntimeException{
    public NoResourceFoundException(String message) {
        super(message);
    }
}
