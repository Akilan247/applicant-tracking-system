package com.akilan.application_tracking_system.Exception.ExceptionHandler;


import com.akilan.application_tracking_system.Exception.AlreadyAppliedException;
import com.akilan.application_tracking_system.Exception.ApplicantNotFoundException;
import com.akilan.application_tracking_system.Exception.ExceptionResponse.ExceptionResponse;
import com.akilan.application_tracking_system.Exception.JobNotFoundException;
import com.akilan.application_tracking_system.Exception.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;

@RestControllerAdvice
public class GlobaExceptionHandler {

    @ExceptionHandler(ApplicantNotFoundException.class)
    public ResponseEntity<ExceptionResponse> applicantNotFountException(ApplicantNotFoundException e){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalTime.now(),e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<ExceptionResponse> jobNotFound(JobNotFoundException e){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalTime.now(),e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyAppliedException.class)
    public ResponseEntity<ExceptionResponse> applicantAlreadyApplied(AlreadyAppliedException e){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalTime.now(),e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> userAlreadyExistException(UserAlreadyExistException e){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalTime.now(),e.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
