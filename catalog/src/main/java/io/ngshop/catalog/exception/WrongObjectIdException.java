package io.ngshop.catalog.exception;

public class WrongObjectIdException extends RuntimeException{
    public WrongObjectIdException(String message) {
        super(message);
    }
}
