package com.akilan.application_tracking_system.Repo;

import com.akilan.application_tracking_system.Entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Long> {
    boolean existsByEmail(String email);
}
