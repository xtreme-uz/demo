package com.example.demo.config;

import com.example.demo.service.exception.ObjectFieldRequiredException;
import com.example.demo.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponse> sqlExceptionHandler(SQLException e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> runtimeExceptionHandler(RuntimeException e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFoundHandler(ObjectNotFoundException e, WebRequest request, HttpServletRequest servletRequest) {
//        e.getMyField();
        ErrorResponse response = new ErrorResponse(e.getMessage(), servletRequest.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ObjectFieldRequiredException.class)
    public ResponseEntity<ErrorResponse> fieldRequiredHandler(ObjectFieldRequiredException e, WebRequest request) {
        ErrorResponse response = new ErrorResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
