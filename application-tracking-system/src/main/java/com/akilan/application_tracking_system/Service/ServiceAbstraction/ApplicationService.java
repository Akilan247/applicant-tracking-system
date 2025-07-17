package com.akilan.application_tracking_system.Service.ServiceAbstraction;


import com.akilan.application_tracking_system.DTO.RequestDto.ApplicationRequestDto;
import com.akilan.application_tracking_system.DTO.Response.ApplicationResponseDto;
import com.akilan.application_tracking_system.Entity.Application;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApplicationService {

     ResponseEntity<ApplicationResponseDto> applyForJob(ApplicationRequestDto applicationRequestDto);

     ResponseEntity<?> getAllApplicationByApplicantId(Long applicantId);
}
