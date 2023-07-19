package io.ngshop.catalog.exceptionHandler;

import io.ngshop.catalog.dto.exceptionsDto.ErrorDto;
import io.ngshop.catalog.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto notFoundHandler(NotFoundException e){
        return ErrorDto.builder().error(e.getMessage()).build();
    }
}
