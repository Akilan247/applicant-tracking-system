package com.akilan.application_tracking_system.Exception.ExceptionHandler;

import com.akilan.application_tracking_system.Exception.AlreadyAppliedException;
import com.akilan.application_tracking_system.Exception.ApplicantNotFoundException;
import com.akilan.application_tracking_system.Exception.ApplicationNotFoundException;
import com.akilan.application_tracking_system.Exception.ExceptionResponse.ExceptionResponse;
import com.akilan.application_tracking_system.Exception.JobNotFoundException;
import com.akilan.application_tracking_system.Exception.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobaExceptionHandler {

    @ExceptionHandler(ApplicantNotFoundException.class)
    public ResponseEntity<ExceptionResponse> applicantNotFountException(ApplicantNotFoundException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalTime.now(), e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<ExceptionResponse> jobNotFound(JobNotFoundException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalTime.now(), e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyAppliedException.class)
    public ResponseEntity<ExceptionResponse> applicantAlreadyApplied(AlreadyAppliedException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalTime.now(), e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> userAlreadyExistException(UserAlreadyExistException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalTime.now(), e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<ExceptionResponse> ApplicationNotFoundException(ApplicationNotFoundException e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalTime.now(), e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .findFirst()
                .orElse("Invalid Input");

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", errorMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
