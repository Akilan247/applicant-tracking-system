package com.akilan.application_tracking_system.Controller;


import com.akilan.application_tracking_system.DTO.RequestDto.ApplicationRequestDto;
import com.akilan.application_tracking_system.DTO.Response.ApplicantResponseDto;
import com.akilan.application_tracking_system.DTO.Response.ApplicationResponseDto;
import com.akilan.application_tracking_system.Service.ServiceAbstraction.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    public ApplicationService applicationService;

    @PostMapping("/apply-for-job")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ApplicationResponseDto> applyForJob(
            @RequestParam Long jobId,
            @RequestParam Long applicantId){
        String status = "Applied";
        ApplicationRequestDto applicationRequestDto = new ApplicationRequestDto(
                jobId,
                applicantId,
                status,
                LocalDate.now()
        );
        return applicationService.applyForJob(applicationRequestDto);
    }

    @GetMapping("/get-all-applications-by-id/{applicantId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getAllApplicationsByApplicantId(@PathVariable Long applicantId){
        return ResponseEntity.ok(applicationService.getAllApplicationByApplicantId(applicantId));
    }

}
