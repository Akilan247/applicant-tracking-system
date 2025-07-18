package com.akilan.application_tracking_system.Service.ServiceAbstraction;


import com.akilan.application_tracking_system.DTO.RequestDto.ApplicationRequestDto;
import com.akilan.application_tracking_system.DTO.Response.ApplicationResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ApplicationService {

     ResponseEntity<ApplicationResponseDto> applyForJob(ApplicationRequestDto applicationRequestDto);

     ResponseEntity<?> getAllApplicationByApplicantId(Long applicantId);

     ApplicationResponseDto updateApplicationStatus(Long applicantId, Long jobId,String status);

     ApplicationResponseDto applyWithResume(Long applicantId, Long jobId, MultipartFile resume);

     int applicationCountByJobId(Long jobId);
}
