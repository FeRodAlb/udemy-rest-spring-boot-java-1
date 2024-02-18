package com.udemyrestspringbootjava1.advice;


import com.udemyrestspringbootjava1.exception.ExceptionResponse;
import com.udemyrestspringbootjava1.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now(), ex.getMessage());
        return new ResponseEntity<>(response, response.getStatusCode());
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(HttpStatus.NOT_FOUND, LocalDateTime.now(), ex.getMessage());

        return new ResponseEntity<>(response, response.getStatusCode());
    }

}
