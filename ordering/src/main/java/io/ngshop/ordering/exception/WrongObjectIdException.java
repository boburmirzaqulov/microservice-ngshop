package io.ngshop.ordering.exception;

public class WrongObjectIdException extends RuntimeException{
    public WrongObjectIdException(String message) {
        super(message);
    }
}
