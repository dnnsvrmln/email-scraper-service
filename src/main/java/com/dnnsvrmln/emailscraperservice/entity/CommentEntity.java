package com.dnnsvrmln.emailscraperservice.entity;

import lombok.Data;

@Data
public class CommentEntity {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
