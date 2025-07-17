package com.akilan.application_tracking_system.Service.ServiceAbstraction;

import com.akilan.application_tracking_system.DTO.RequestDto.ApplicantRequestDto;
import com.akilan.application_tracking_system.DTO.Response.ApplicantResponseDto;
import com.akilan.application_tracking_system.Entity.Applicant;
import org.springframework.http.ResponseEntity;

public interface ApplicantService {

      ResponseEntity<ApplicantResponseDto> registerApplicant(ApplicantRequestDto applicantRequestDto);

      Applicant findById(Long id);
}
