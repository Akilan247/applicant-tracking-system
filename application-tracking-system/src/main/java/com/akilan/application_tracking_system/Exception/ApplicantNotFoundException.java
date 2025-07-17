package com.akilan.application_tracking_system.Exception;

public class ApplicantNotFoundException extends RuntimeException {

    public ApplicantNotFoundException(String msg){
        super(msg);
    }
}
