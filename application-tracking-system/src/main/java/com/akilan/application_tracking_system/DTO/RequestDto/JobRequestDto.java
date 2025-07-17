package com.akilan.application_tracking_system.DTO.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobRequestDto {

    private String title;
    private String jobDescription;
    private LocalDate postedDate;
}
