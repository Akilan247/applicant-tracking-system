package com.akilan.application_tracking_system.Service;

import com.akilan.application_tracking_system.DTO.RequestDto.ApplicantRequestDto;
import com.akilan.application_tracking_system.DTO.Response.ApplicantResponseDto;
import com.akilan.application_tracking_system.DTO.Mapper.ApplicantMapper;
import com.akilan.application_tracking_system.Entity.Applicant;
import com.akilan.application_tracking_system.Repo.ApplicantRepository;
import com.akilan.application_tracking_system.Service.ServiceAbstraction.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicantServiceImp implements ApplicantService {

    @Autowired
    ApplicantRepository applicantRepository;


    @Override
    public ResponseEntity<ApplicantResponseDto> registerApplicant(ApplicantRequestDto applicantRequestDto) {

        if(applicantRequestDto==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        if(applicantRepository.existsByEmail(applicantRequestDto.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null); // or throw a custom exception
        }

        Applicant applicant = ApplicantMapper.dtoToApplicantMapper(applicantRequestDto);
        Applicant savedApplicant = applicantRepository.save(applicant);
        ApplicantResponseDto response = ApplicantMapper.applicantToDtoMapper(savedApplicant);
        return ResponseEntity.ok(response);
    }

    @Override
    public Applicant findById(Long id) {
      Optional<Applicant> optionalApplicant = applicantRepository.findById(id);
      if(optionalApplicant.isPresent()){
          return optionalApplicant.get();
      }else {
          throw new RuntimeException("Applicant not found..");
      }
    }
}
