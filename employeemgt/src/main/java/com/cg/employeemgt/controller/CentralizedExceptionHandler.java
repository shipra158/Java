package com.cg.employeemgt.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import com.cg.employeemgt.exceptions.EmployeeNotFoundException;
import com.cg.employeemgt.exceptions.InvalidEmployeeNameException;
import com.cg.employeemgt.exceptions.InvalidScoreException;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFound(EmployeeNotFoundException e){
        return  e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidEmployeeNameException.class)
    public  String handleInvalidName(InvalidEmployeeNameException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidScoreException.class)
    public String handleInvalidScore(InvalidScoreException e){
        return e.getMessage();
    }


}
