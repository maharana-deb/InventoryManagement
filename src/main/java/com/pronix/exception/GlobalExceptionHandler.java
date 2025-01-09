package com.pronix.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ExceptionUtil exceptionUtil;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> resourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        return exceptionUtil.buildResponseEntity(exception, HttpStatus.OK, request);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String, Object>> badRequestException(BadRequestException exception, WebRequest request){
        return exceptionUtil.buildResponseEntity(exception, HttpStatus.OK, request);
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<Map<String, Object>> authenticationFailedException(AuthenticationFailedException exception, WebRequest request){
        return exceptionUtil.buildResponseEntity(exception, HttpStatus.OK, request);
    }

    @ExceptionHandler(NoDataAvailableException.class)
    public ResponseEntity<Map<String, Object>> noDataAvailableException(NoDataAvailableException exception, WebRequest request){
        return exceptionUtil.buildResponseEntity(exception, HttpStatus.OK, request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException exception){
        Map<String, Object> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> errors.put("message", error.getDefaultMessage()));
        return new ResponseEntity<>(errors, HttpStatus.OK);
    }

}
