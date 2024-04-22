package com.demo.jobsystem.service;

import com.demo.jobsystem.entity.User;
import com.demo.jobsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User User) {
        return userRepository.save(User);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}