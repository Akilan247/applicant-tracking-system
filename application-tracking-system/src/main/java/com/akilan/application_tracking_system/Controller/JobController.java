package com.akilan.application_tracking_system.Controller;

import com.akilan.application_tracking_system.DTO.RequestDto.JobRequestDto;
import com.akilan.application_tracking_system.Service.ServiceAbstraction.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping("/post")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> postJob(@RequestBody JobRequestDto jobRequestDto){
        jobRequestDto.setPostedDate(LocalDate.now());
        jobService.postJob(jobRequestDto);
        return ResponseEntity.ok("Job posted successfully...");
    }

    @GetMapping("/all-jobs")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getAllJobs(){
        System.out.println("In job controller...");
        return jobService.getAllJobs();
    }
}
