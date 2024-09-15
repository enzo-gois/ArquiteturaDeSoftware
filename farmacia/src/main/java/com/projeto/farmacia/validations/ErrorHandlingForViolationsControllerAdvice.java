package com.projeto.farmacia.validations;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlingForViolationsControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onMethodArgumentNotValidexception(MethodArgumentNotValidException e) {
        ValidationErrorResponse error = new ValidationErrorResponse();

        for(FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            error.setViolation(new Violation(fieldError.getField(),fieldError.getDefaultMessage()));

        }

        System.out.println("Method Argument Violation");
        return error;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {
        ValidationErrorResponse error = new ValidationErrorResponse();

        for (ConstraintViolation violation: e.getConstraintViolations()) {
            error.setViolation(new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
        }
        System.out.println("Constraint Violation");

        return error;
    }

}
