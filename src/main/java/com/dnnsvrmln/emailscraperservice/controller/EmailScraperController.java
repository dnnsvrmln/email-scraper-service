package com.dnnsvrmln.emailscraperservice.controller;

import com.dnnsvrmln.emailscraperservice.entity.EmailEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmailScraperController {
    @Operation(tags = "Email Scraper API - Emails", summary = "Get all emails", description = "Get all emails from Email Scraper API")
    @ApiResponse(responseCode = "200", description = "Found all emails")
    ResponseEntity<List<EmailEntity>> getEmails();
}
