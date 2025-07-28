package com.akilan.application_tracking_system.Controller;

import com.akilan.application_tracking_system.DTO.RequestDto.ApplicantRequestDto;
import com.akilan.application_tracking_system.DTO.Response.ApplicantResponseDto;
import com.akilan.application_tracking_system.DTO.RequestDto.ResumeRequestDto;
import com.akilan.application_tracking_system.Entity.Applicant;
import com.akilan.application_tracking_system.Entity.Resume;
import com.akilan.application_tracking_system.Service.ServiceAbstraction.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api/applicant")
public class ApplicantController {

    @Autowired
    ApplicantService applicantService;

    @PostMapping(value = "/add", consumes = "multipart/form-data")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ApplicantResponseDto> addApplicant(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestPart("resume") MultipartFile resumeFile) throws IOException {

        ResumeRequestDto resumeDto = new ResumeRequestDto(
                resumeFile.getOriginalFilename(),
                resumeFile.getContentType(),
                resumeFile.getBytes()
        );

        ApplicantRequestDto applicantRequestDto = new ApplicantRequestDto(name, email, phone, resumeDto);

        return applicantService.registerApplicant(applicantRequestDto);
    }

    @GetMapping("/download_resume/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<byte[]> downloadResume(@PathVariable("id") Long id){
        Applicant applicant = applicantService.findById(id);
        Resume resume = applicant.getResume();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resume.getFileName())
                .contentType(MediaType.parseMediaType(resume.getFileType()))
                .body(resume.getFileData());
    }



}

