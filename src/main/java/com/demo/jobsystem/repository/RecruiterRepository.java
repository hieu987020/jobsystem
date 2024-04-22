package com.demo.jobsystem.repository;

import com.demo.jobsystem.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
}