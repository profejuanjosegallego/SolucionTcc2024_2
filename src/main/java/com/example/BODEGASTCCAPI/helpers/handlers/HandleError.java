package com.example.BODEGASTCCAPI.helpers.handlers;

import com.example.BODEGASTCCAPI.helpers.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandleError {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception e) {
        Map<String, Object> responseMessage = new HashMap<>();
        responseMessage.put("message", e.getMessage());
        responseMessage.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseMessage.put("timestamp", System.currentTimeMillis());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(responseMessage);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException e) {
        Map<String, Object> responseMessage = new HashMap<>();
        responseMessage.put("message", e.getMessage());
        responseMessage.put("status", HttpStatus.NOT_FOUND.value());
        responseMessage.put("timestamp", System.currentTimeMillis());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(responseMessage);
    }
}
