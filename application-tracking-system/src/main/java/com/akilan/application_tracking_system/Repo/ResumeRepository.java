package com.akilan.application_tracking_system.Repo;

import com.akilan.application_tracking_system.Entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume,Long> {
}
