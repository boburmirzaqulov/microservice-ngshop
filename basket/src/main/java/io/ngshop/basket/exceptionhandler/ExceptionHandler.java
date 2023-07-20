package io.ngshop.basket.exceptionhandler;

import io.ngshop.basket.customexception.NoResourceFoundException;
import io.ngshop.basket.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDTO notFoundHandler(NoResourceFoundException ex) {
        ex.printStackTrace();
        return ErrorDTO.builder().error(ex.getMessage()).build();
    }

}
