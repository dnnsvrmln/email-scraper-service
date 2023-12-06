package com.dnnsvrmln.emailscraperservice.service;

import com.dnnsvrmln.emailscraperservice.entity.EmailEntity;
import com.dnnsvrmln.emailscraperservice.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public List<EmailEntity> findAllEmails() {
        return emailRepository.findAll();
    }

    public void saveEmail(String email) {
        var emailEntity = new EmailEntity();
        emailEntity.setEmail(email);
        emailRepository.save(emailEntity);
    }

    public void deleteAllEmails() {
        emailRepository.deleteAll();
    }

}
