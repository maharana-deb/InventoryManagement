package com.pronix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ExceptionUtil {

    public Map<String, Object> createError(String message, WebRequest request){

        Map<String, Object> errorDetails = new LinkedHashMap<>();

        errorDetails.put("Message", message);
        errorDetails.put("Path", request.getDescription(false));
        errorDetails.put("Time", LocalDateTime.now());

        return errorDetails;

    }

    public ResponseEntity<Map<String, Object>> buildResponseEntity(Exception exception, HttpStatus status, WebRequest request){

        Map<String, Object> errorDetails = createError(exception.getMessage(), request);
        return new ResponseEntity<>(errorDetails, status);

    }

}
