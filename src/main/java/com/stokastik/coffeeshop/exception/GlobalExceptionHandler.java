package com.stokastik.coffeeshop.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String, String>> handleValidatioException(MethodArgumentNotValidException ex) {
        HashMap<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CoffeeNotFoundException.class)
    public ResponseEntity<HashMap<String, String>> handleCoffeeNotFoundException(CoffeeNotFoundException ex) {
        HashMap<String, String> errors = new HashMap<>();
        errors.put("error", "Resource not found");
        errors.put("message", ex.getMessage());

        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);
    }
}
