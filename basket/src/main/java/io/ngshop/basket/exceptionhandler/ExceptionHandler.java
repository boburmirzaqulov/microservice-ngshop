package io.ngshop.basket.exceptionhandler;


import io.ngshop.basket.customexception.NoResourceFoundException;
import io.ngshop.basket.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ErrorDTO> ex(NoResourceFoundException e){
        return ResponseEntity.ok(ErrorDTO.builder().error(e.getMessage()).build());
    }
}
