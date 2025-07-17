package com.akilan.application_tracking_system.DTO.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantResponseDto {

    private String name;
    private String email;
    private String phone;
    private ResumeResponseDto resume;

}
