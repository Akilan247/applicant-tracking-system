package com.akilan.application_tracking_system.Service;


import com.akilan.application_tracking_system.DTO.RequestDto.JobRequestDto;
import com.akilan.application_tracking_system.DTO.Mapper.JobMapper;
import com.akilan.application_tracking_system.Entity.Job;
import com.akilan.application_tracking_system.Exception.JobNotFoundException;
import com.akilan.application_tracking_system.Repo.JobRepository;
import com.akilan.application_tracking_system.Service.ServiceAbstraction.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImp implements JobService {

    @Autowired
    JobRepository jobRepository;

    @Override
    public void postJob(JobRequestDto jobRequestDto) {

        Job job = JobMapper.dtoToJobMapper(jobRequestDto);

        jobRepository.save(job);
    }

    @Override
    public ResponseEntity<?> getAllJobs() {
        List<Job> jobList = jobRepository.findAll();
        if(jobList.isEmpty()){
            throw new JobNotFoundException("No jobs posted yet");
        }
        return ResponseEntity.ok(JobMapper.JobToDtoMapper(jobList));
    }
}
