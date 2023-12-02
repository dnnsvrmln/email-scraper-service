package com.dnnsvrmln.emailscraperservice.repository;

import com.dnnsvrmln.emailscraperservice.entity.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> {
}
