package com.akilan.application_tracking_system.Exception;

public class ApplicationNotFoundException extends RuntimeException{
    public ApplicationNotFoundException(String msg){
        super(msg);
    }
}
