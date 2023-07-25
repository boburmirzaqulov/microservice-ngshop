package io.ngshop.basket.customexception;

import lombok.*;

public class NoResourceFoundException extends RuntimeException {
    public NoResourceFoundException(String message) {
        super(message);
    }
}
