package com.akilan.application_tracking_system.DTO.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobResponseDto {

    private Long JobId;
    private String title;
    private String jobDescription;
    private LocalDate postedTime;
}
