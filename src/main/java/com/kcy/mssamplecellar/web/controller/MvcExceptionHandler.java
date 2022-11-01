package com.kcy.mssamplecellar.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex) {
        List<String> errorList = new ArrayList<>(ex.getConstraintViolations().size());

        ex.getConstraintViolations().forEach(error -> errorList.add(error.toString()));
        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<List> validationErrorHandler(MethodArgumentNotValidException ex) {
        List<String> errorList = new ArrayList<>(ex.getErrorCount());

        ex.getAllErrors().forEach(error -> {
            if (error instanceof FieldError) {
                FieldError fe = (FieldError) error;
                errorList.add(fe.getField() + " " + fe.getDefaultMessage());
            } else {
                errorList.add(error.getObjectName() + " " + error.getDefaultMessage());
            }
        });

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }
}
