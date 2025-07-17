package com.akilan.application_tracking_system.Exception;


public class JobNotFoundException extends RuntimeException {

    public JobNotFoundException(String msg){
        super(msg);
    }
}
