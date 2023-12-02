package com.dnnsvrmln.emailscraperservice.entity;

import lombok.Data;

@Data
public class PostEntity {
    private int userId;
    private int id;
    private String title;
    private String body;
}
