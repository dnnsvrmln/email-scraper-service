package com.dnnsvrmln.emailscraperservice.controller;

import com.dnnsvrmln.emailscraperservice.entity.CommentEntity;
import com.dnnsvrmln.emailscraperservice.entity.PostEntity;
import com.dnnsvrmln.emailscraperservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlaceholderAPIControllerImpl implements PlaceholderAPIController {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    @Autowired
    private EmailService emailService;

    @GetMapping("/posts")
    public ResponseEntity<List<PostEntity>> getPosts() {
        var url = createUrl("posts");
        var response = REST_TEMPLATE.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<PostEntity>>() {
        });

        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostEntity> getPost(@PathVariable("id") int id) {
        var url = createUrl("posts/" + id);

        var response = REST_TEMPLATE.exchange(url, HttpMethod.GET, null, PostEntity.class);

        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentEntity>> getCommentsFromPost(@PathVariable("postId") int id) {
        var url = createUrl("posts/" + id + "/comments");

        var response = REST_TEMPLATE.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CommentEntity>>() {
        });
        extractEmailsFromResponse(response.getBody());

        return ResponseEntity.ok(response.getBody());
    }

    private static String createUrl(String endpoint) {
        return BASE_URL + endpoint;
    }

    private void extractEmailsFromResponse(List<CommentEntity> commentEntities) {
        if (commentEntities != null) {
            for (CommentEntity commentEntity : commentEntities) {
                String email = commentEntity.getEmail();
                System.out.println("Email: " + email);
                emailService.saveEmail(email);
            }
        }
    }
}
