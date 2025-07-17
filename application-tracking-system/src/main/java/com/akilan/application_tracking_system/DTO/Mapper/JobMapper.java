package com.akilan.application_tracking_system.DTO.Mapper;

import com.akilan.application_tracking_system.DTO.RequestDto.JobRequestDto;
import com.akilan.application_tracking_system.DTO.Response.JobResponseDto;
import com.akilan.application_tracking_system.Entity.Job;

import java.util.ArrayList;
import java.util.List;

public class JobMapper {

    public static Job dtoToJobMapper(JobRequestDto jobRequestDto){
        Job job = new Job();
        job.setTitle(jobRequestDto.getTitle());
        job.setJobDescription(jobRequestDto.getJobDescription());
        job.setPostedDate(jobRequestDto.getPostedDate());
        return job;
    }

    public static List<JobResponseDto> JobToDtoMapper(List<Job> jobList) {

        List<JobResponseDto> jobResponseDtoList = new ArrayList<>();
        for(Job job : jobList){
            jobResponseDtoList.add(
                   new JobResponseDto(
                           job.getId(),
                           job.getTitle(),
                           job.getJobDescription(),
                           job.getPostedDate()
                   )
            );
        }
        return jobResponseDtoList;
    }
}
