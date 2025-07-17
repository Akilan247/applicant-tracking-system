package com.akilan.application_tracking_system.DTO.Mapper;

import com.akilan.application_tracking_system.DTO.RequestDto.ApplicantRequestDto;
import com.akilan.application_tracking_system.DTO.Response.ApplicantResponseDto;
import com.akilan.application_tracking_system.DTO.Response.ResumeResponseDto;
import com.akilan.application_tracking_system.Entity.Applicant;
import com.akilan.application_tracking_system.Entity.Resume;
import org.springframework.stereotype.Component;

@Component
public class ApplicantMapper {


    public static Applicant dtoToApplicantMapper(ApplicantRequestDto applicantRequestDto) {
        Applicant applicant = new Applicant();

        Resume resume = new Resume();
        resume.setFileName(applicantRequestDto.getResume().getFileName());
        resume.setFileType(applicantRequestDto.getResume().getFileType());
        resume.setFileData(applicantRequestDto.getResume().getFileData());

        //Set the back-reference
        resume.setApplicant(applicant);
        // Set the forward-reference
        applicant.setResume(resume);

        applicant.setName(applicantRequestDto.getName());
        applicant.setEmail(applicantRequestDto.getEmail());
        applicant.setPhone(applicantRequestDto.getPhone());

        return applicant;
    }

    public static ApplicantResponseDto applicantToDtoMapper(Applicant applicant){
        String downloadUrl = "http://localhost:8080/api/applicant/download_resume/"+applicant.getId();
        ResumeResponseDto resumeResponseDto = new ResumeResponseDto(
                applicant.getResume().getFileName(),
                applicant.getResume().getFileType(),
                downloadUrl
        );
        ApplicantResponseDto applicantResponseDto = new ApplicantResponseDto();
        applicantResponseDto.setName(applicant.getName());
        applicantResponseDto.setEmail(applicant.getEmail());
        applicantResponseDto.setPhone(applicant.getPhone());
        applicantResponseDto.setResume(resumeResponseDto);
        return applicantResponseDto;
    }
}
