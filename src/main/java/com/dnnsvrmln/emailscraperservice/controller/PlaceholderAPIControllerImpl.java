package com.dnnsvrmln.emailscraperservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlaceholderAPIControllerImpl implements PlaceholderAPIController {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    @GetMapping("/posts")
    public ResponseEntity<String> getPosts() {
        var url = createUrl("posts");

        var response = REST_TEMPLATE.getForObject(url, String.class);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<String> getPost(@PathVariable("id") int id) {
        var url = createUrl("posts/" + id);

        var response = REST_TEMPLATE.getForObject(url, String.class);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<String> getCommentsFromPost(@PathVariable("postId") int id) {
        var url = createUrl("posts/" + id + "/comments");

        var response = REST_TEMPLATE.getForObject(url, String.class);

        return ResponseEntity.ok(response);
    }

    private static String createUrl(String endpoint) {
        return BASE_URL + endpoint;
    }
}
