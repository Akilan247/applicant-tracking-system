package com.akilan.application_tracking_system.Service.ServiceAbstraction;

import com.akilan.application_tracking_system.DTO.RequestDto.JobRequestDto;
import org.springframework.http.ResponseEntity;

public interface JobService {
    void postJob(JobRequestDto jobRequestDto);

    ResponseEntity<?> getAllJobs();
}
