package com.akilan.application_tracking_system.DTO.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeRequestDto {

    private String fileName;
    private String fileType;
    private byte[] fileData;

}
