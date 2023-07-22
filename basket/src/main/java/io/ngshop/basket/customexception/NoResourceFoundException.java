package io.ngshop.basket.customexception;

public class NoResourceFoundException extends RuntimeException{
    public NoResourceFoundException(String message) {
        super(message);
    }
}
