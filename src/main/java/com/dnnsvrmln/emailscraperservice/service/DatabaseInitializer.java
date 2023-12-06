package com.dnnsvrmln.emailscraperservice.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    @Autowired
    private EmailService emailService;

    @PostConstruct
    public void initializeDatabase() {
        emailService.deleteAllEmails();
    }

}
