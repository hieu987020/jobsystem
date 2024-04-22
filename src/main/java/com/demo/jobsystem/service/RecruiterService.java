package com.demo.jobsystem.service;

import com.demo.jobsystem.entity.Recruiter;
import com.demo.jobsystem.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }

    public Optional<Recruiter> getRecruiterById(Long id) {
        return recruiterRepository.findById(id);
    }

    public Recruiter createRecruiter(Recruiter recruiter) {
        return recruiterRepository.save(recruiter);
    }

    public Optional<Recruiter> updateRecruiter(Long id, Recruiter recruiterDetails) {
        Optional<Recruiter> optionalRecruiter = recruiterRepository.findById(id);
        if (optionalRecruiter.isPresent()) {
            Recruiter recruiter = optionalRecruiter.get();
            recruiter.setName(recruiterDetails.getName());
            recruiter.setDescription(recruiterDetails.getDescription());
            recruiter.setEmail(recruiterDetails.getEmail());
            recruiter.setPhone(recruiterDetails.getPhone());
            return Optional.of(recruiterRepository.save(recruiter));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteRecruiter(Long id) {
        if (recruiterRepository.existsById(id)) {
            recruiterRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}