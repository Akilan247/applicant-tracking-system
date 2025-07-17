package com.akilan.application_tracking_system.Repo;

import com.akilan.application_tracking_system.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsJpaRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByUserName(String userName);
}