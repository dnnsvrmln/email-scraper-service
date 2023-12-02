package com.dnnsvrmln.emailscraperservice.controller;

import com.dnnsvrmln.emailscraperservice.entity.EmailEntity;
import com.dnnsvrmln.emailscraperservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmailScraperControllerImpl implements EmailScraperController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/emails")
    public ResponseEntity<List<EmailEntity>> getEmails() {
        var emailEntities = emailService.findAllEmails();

        return ResponseEntity.ok(emailEntities);
    }

}
