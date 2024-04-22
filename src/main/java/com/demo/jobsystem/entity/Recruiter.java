package com.demo.jobsystem.entity;

import jakarta.persistence.*;
@Entity
@Table(name="recruiter")
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recruiter_id") // Mapping the id field to a column named recruiter_id
    private Long id;

    // Define the many-to-one relationship
    @ManyToOne(fetch = FetchType.LAZY) // Change FetchType.LAZY to FetchType.EAGER if needed
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "recruiter_name") // Mapping the name field to a column named recruiter_name
    private String name;

    @Column(name = "recruiter_description") // Mapping the description field to a column named recruiter_description
    private String description;

    @Column(name = "recruiter_email") // Mapping the email field to a column named recruiter_email
    private String email;

    @Column(name = "recruiter_phone") // Mapping the phone field to a column named recruiter_phone
    private String phone;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}