package com.akilan.application_tracking_system.Repo;

import com.akilan.application_tracking_system.Entity.Applicant;
import com.akilan.application_tracking_system.Entity.Application;
import com.akilan.application_tracking_system.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {

    boolean existsByApplicantAndJob(Applicant applicant, Job job);

    List<Application> findAllApplicationsByApplicantId(Long applicantId);
}
