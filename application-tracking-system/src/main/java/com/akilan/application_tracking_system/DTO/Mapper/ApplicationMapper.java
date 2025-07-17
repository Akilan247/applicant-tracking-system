package com.akilan.application_tracking_system.DTO.Mapper;

import com.akilan.application_tracking_system.DTO.RequestDto.ApplicationRequestDto;
import com.akilan.application_tracking_system.DTO.Response.ApplicantResponseDto;
import com.akilan.application_tracking_system.DTO.Response.ApplicationResponseDto;
import com.akilan.application_tracking_system.DTO.Response.JobResponseDto;
import com.akilan.application_tracking_system.Entity.Applicant;
import com.akilan.application_tracking_system.Entity.Application;
import com.akilan.application_tracking_system.Entity.Job;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class ApplicationMapper {

    public static Application DtoToApplication(
            ApplicationRequestDto applicationRequestDto,
            Applicant applicant,
            Job job) {

        Application application = new Application();

        application.setApplicant(applicant);
        application.setJob(job);
        application.setDate(applicationRequestDto.getDate());
        application.setStatus(applicationRequestDto.getStatus());

        return application;
    }

    public static ApplicationResponseDto ApplicationToResponse(Application application,
                                                               Job job,
                                                               Applicant applicant) {
        JobResponseDto jobResponseDto = new JobResponseDto(job.getId(),
                job.getTitle(), job.getJobDescription(), job.getPostedDate()
        );
        return new ApplicationResponseDto(
                application.getId(),
                applicant.getId(),
                application.getDate(),
                application.getStatus(),
                jobResponseDto
        );
    }

    public static List<ApplicationResponseDto> entityListToDtos(List<Application> applicationsList) {

        List<ApplicationResponseDto> applicationResponseDtoList = new ArrayList<>();

        for(Application application : applicationsList){

            JobResponseDto jobResponseDto = new JobResponseDto(
                    application.getJob().getId(),
                    application.getJob().getTitle(),
                    application.getJob().getJobDescription(),
                    application.getJob().getPostedDate()
            );

            applicationResponseDtoList.add(
                    new ApplicationResponseDto(
                            application.getId(),
                            application.getApplicant().getId(),
                            application.getDate(),
                            application.getStatus(),
                            jobResponseDto
                    )
            );
        }

        return applicationResponseDtoList;
    }
}
