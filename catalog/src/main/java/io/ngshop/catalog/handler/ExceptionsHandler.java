package io.ngshop.catalog.handler;

import io.ngshop.catalog.dto.error.ErrorDto;
import io.ngshop.catalog.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto notFoundHandler(NotFoundException exception){
        return ErrorDto.builder()
                .message(exception.getMessage())
                .build();
    }
}
