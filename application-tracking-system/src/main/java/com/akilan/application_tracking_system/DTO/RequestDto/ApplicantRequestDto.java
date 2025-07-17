package com.akilan.application_tracking_system.DTO.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantRequestDto {

    private String name;
    private String email;
    private String phone;
    private ResumeRequestDto resume;
    
}
