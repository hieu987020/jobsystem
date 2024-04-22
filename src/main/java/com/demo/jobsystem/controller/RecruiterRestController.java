package com.demo.jobsystem.controller;

import com.demo.jobsystem.entity.Recruiter;
import com.demo.jobsystem.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterRestController {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @GetMapping
    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }

    @GetMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable Long id) {
        return recruiterRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Recruiter createRecruiter(@RequestBody Recruiter recruiter) {
        return recruiterRepository.save(recruiter);
    }

    @PutMapping("/{id}")
    public Recruiter updateRecruiter(@PathVariable Long id, @RequestBody Recruiter recruiterDetails) {
        Recruiter recruiter = recruiterRepository.findById(id).orElse(null);
        if (recruiter != null) {
            recruiter.setName(recruiterDetails.getName());
            recruiter.setDescription(recruiterDetails.getDescription());
            recruiter.setEmail(recruiterDetails.getEmail());
            recruiter.setPhone(recruiterDetails.getPhone());
            return recruiterRepository.save(recruiter);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteRecruiter(@PathVariable Long id) {
        recruiterRepository.deleteById(id);
    }
}