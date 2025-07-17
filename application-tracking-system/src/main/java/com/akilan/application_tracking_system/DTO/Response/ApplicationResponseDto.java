package com.akilan.application_tracking_system.DTO.Response;


import com.akilan.application_tracking_system.Entity.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationResponseDto {

    private Long applicationId;
    private Long applicantId;
    private LocalDate localDate;
    private String status;
    private JobResponseDto job;

}
