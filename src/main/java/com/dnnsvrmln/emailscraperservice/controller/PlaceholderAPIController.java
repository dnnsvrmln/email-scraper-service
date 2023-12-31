package com.dnnsvrmln.emailscraperservice.controller;

import com.dnnsvrmln.emailscraperservice.entity.CommentEntity;
import com.dnnsvrmln.emailscraperservice.entity.PostEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlaceholderAPIController {

    @Operation(tags = "JSON Placeholder API - Posts", summary = "Get all posts", description = "Get all posts from JSON Placeholder API")
    @ApiResponse(responseCode = "200", description = "Found all posts")
    ResponseEntity<List<PostEntity>> getPosts(HttpServletRequest request);

    @Operation(tags = "JSON Placeholder API - Posts", summary = "Get a post by id", description = "Get a specific post by id from JSON Placeholder API")
    @ApiResponse(responseCode = "200", description = "Found the specific post by id")
    @ApiResponse(responseCode = "400", description = "Bad request - Invalid id")
    @ApiResponse(responseCode = "404", description = "Post not found")
    ResponseEntity<PostEntity> getPost(HttpServletRequest request, @Parameter(name = "id", in = ParameterIn.PATH, description = "Id of the specific post", example = "1") int id);

    @Operation(tags = "JSON Placeholder API - Comments", summary = "Get all comments from a post", description = "Get all comments from a specific post by post id from JSON Placeholder API")
    @ApiResponse(responseCode = "200", description = "Found the comments from a post by id")
    @ApiResponse(responseCode = "400", description = "Bad request - Invalid id")
    @ApiResponse(responseCode = "404", description = "Comments not found from a post by id")
    ResponseEntity<List<CommentEntity>> getCommentsFromPost(HttpServletRequest request, @Parameter(name = "postId", in = ParameterIn.PATH, description = "Post id of the specific post for all comments", example = "1") int postId);

}
