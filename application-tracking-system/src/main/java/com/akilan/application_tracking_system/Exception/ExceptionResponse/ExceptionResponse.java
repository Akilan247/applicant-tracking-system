package com.akilan.application_tracking_system.Exception.ExceptionResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ExceptionResponse {

    private LocalTime localTime;
    private String message;

}
