package com.pracitce.basics.demo.controller;

import com.pracitce.basics.demo.exceptions.BusinessException;
import com.pracitce.basics.demo.DTO.ErrorResponses;
import com.pracitce.basics.demo.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ErrorResponses handlerExceptions(BusinessException businessException){

      return new ErrorResponses(businessException.getMessage(),LocalDateTime.now(),HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponses> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException){
        ErrorResponses errorResponses= new ErrorResponses(illegalArgumentException.getMessage(),LocalDateTime.now(),HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errorResponses,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponses> handleUserNotFoundException(UserNotFoundException userNotFoundException){
        ErrorResponses errorResponses= new ErrorResponses(userNotFoundException.getMessage(),LocalDateTime.now(),HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponses,HttpStatus.NOT_FOUND);
    }
}
