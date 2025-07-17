package com.akilan.application_tracking_system.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeResponseDto {
    private String fileName;
    private String fileType;
    private String downloadResumeUrl;
}
