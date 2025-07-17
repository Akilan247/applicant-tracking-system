package com.akilan.application_tracking_system.Exception;

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(String e){
        super(e);
    }
}
