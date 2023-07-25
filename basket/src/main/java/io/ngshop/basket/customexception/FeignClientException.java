package io.ngshop.basket.customexception;

public class FeignClientException extends RuntimeException{

    public FeignClientException(String message) {
        super(message);
    }
}