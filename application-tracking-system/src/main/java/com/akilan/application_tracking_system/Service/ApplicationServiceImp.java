package com.akilan.application_tracking_system.Service;

import com.akilan.application_tracking_system.DTO.Mapper.ApplicationMapper;
import com.akilan.application_tracking_system.DTO.RequestDto.ApplicationRequestDto;
import com.akilan.application_tracking_system.DTO.Response.ApplicantResponseDto;
import com.akilan.application_tracking_system.DTO.Response.ApplicationResponseDto;
import com.akilan.application_tracking_system.Entity.Applicant;
import com.akilan.application_tracking_system.Entity.Application;
import com.akilan.application_tracking_system.Entity.Job;
import com.akilan.application_tracking_system.Exception.AlreadyAppliedException;
import com.akilan.application_tracking_system.Exception.ApplicantNotFoundException;
import com.akilan.application_tracking_system.Exception.ApplicationNotFoundException;
import com.akilan.application_tracking_system.Exception.JobNotFoundException;
import com.akilan.application_tracking_system.Repo.ApplicantRepository;
import com.akilan.application_tracking_system.Repo.ApplicationRepository;
import com.akilan.application_tracking_system.Repo.JobRepository;
import com.akilan.application_tracking_system.Service.ServiceAbstraction.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationServiceImp implements ApplicationService {

    @Autowired
    public ApplicationRepository applicationRepository;

    @Autowired
    public ApplicantRepository applicantRepository;

    @Autowired
    public JobRepository jobRepository;

    @Override
    public ResponseEntity<ApplicationResponseDto> applyForJob(ApplicationRequestDto applicationRequestDto) {

        Applicant optionalApplicant = applicantRepository.findById(applicationRequestDto.getApplicantId())
                .orElseThrow(() -> new ApplicantNotFoundException(
                        "Applicant not found" + applicationRequestDto.getApplicantId()));

        Job optionalJob = jobRepository.findById(applicationRequestDto.getJobId())
                .orElseThrow(
                        () -> new JobNotFoundException("Job not found for Id : " + applicationRequestDto.getJobId()));

        boolean exists = applicationRepository.existsByApplicantAndJob(optionalApplicant, optionalJob);
        if (exists) {
            throw new AlreadyAppliedException("Already applied to this job.");
        }

        Application application = ApplicationMapper.DtoToApplication(applicationRequestDto,
                optionalApplicant,
                optionalJob);

        ApplicationResponseDto applicantResponseDto = ApplicationMapper.ApplicationToResponse(
                applicationRepository.save(application),
                optionalJob,
                optionalApplicant);

        return ResponseEntity.ok(applicantResponseDto);
    }

    @Override
    public ResponseEntity<List<ApplicationResponseDto>> getAllApplicationByApplicantId(Long applicantId) {

        List<Application> applicationsList = applicationRepository.findAllApplicationsByApplicantId(applicantId);

        if (applicationsList.isEmpty()) {
            throw new ApplicantNotFoundException("Applicant is not yet applied for any job");
        }

        return ResponseEntity.ok(ApplicationMapper.entityListToDtos(applicationsList));
    }

    @Override
    public ApplicationResponseDto updateApplicationStatus(Long applicantId, Long jobId, String status) {

        Applicant optionalApplicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ApplicantNotFoundException("Applicant not found" + applicantId));

        Job optionalJob = jobRepository.findById(jobId)
                .orElseThrow(() -> new JobNotFoundException("Job not found for Id : " + jobId));

        Application application = applicationRepository.findApplicationByApplicantIdAndJobId(applicantId, jobId)
                .orElseThrow(
                        () -> new ApplicationNotFoundException("Application not found"));

        List<String> validStatus = List.of("APPLIED",
                "REVIEWED",
                "REJECTED",
                "HIRED");

        if (!validStatus.contains(status.toUpperCase())) {
            throw new IllegalArgumentException("Invalid Status");
        }

        application.setStatus(status);
        applicationRepository.save(application);

        return ApplicationMapper.ApplicationToResponse(application, optionalJob, optionalApplicant);
    }
    
    @Override
    public ApplicationResponseDto applyWithResume(Long applicantId, Long jobId, MultipartFile resume) {

         Applicant optionalApplicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ApplicantNotFoundException("Applicant not found" + applicantId));

        Job optionalJob = jobRepository.findById(jobId)
                .orElseThrow(() -> new JobNotFoundException("Job not found for Id : " + jobId));

        Application application = new Application();

        throw new UnsupportedOperationException("Unimplemented method 'applyWithResume'");
    }

    @Override
    public int applicationCountByJobId(Long jobId) {
                
        return applicationRepository.countByJobId(jobId); 
        
    }
}
