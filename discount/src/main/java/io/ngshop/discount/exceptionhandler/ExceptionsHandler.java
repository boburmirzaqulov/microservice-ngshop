package io.ngshop.discount.exceptionhandler;

import io.ngshop.discount.customexseption.NoResourceFoundException;
import io.ngshop.discount.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto noResourceHandler(NoResourceFoundException ex){
        return ErrorDto.builder().error(ex.getMessage()).build();
    }
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto noResourceHandler(Throwable ex){
        return ErrorDto.builder().error(ex.getMessage()).build();
    }
}
