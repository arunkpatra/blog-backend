package com.arunkpatra.blog.controller;

import com.arunkpatra.blog.exception.BlogException;
import com.arunkpatra.blog.model.ErrorResponse;
import com.arunkpatra.blog.model.Post;
import com.arunkpatra.blog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class BlogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);
    private final PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value = "/post/{id}", produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<Post> getPost(@PathVariable long id) throws BlogException {

        try {
            return new ResponseEntity<>(postService.getPost(id), HttpStatus.OK);
        } catch (Throwable t) {
            throw new BlogException("Post not found");
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BlogException.class)
    public ErrorResponse handleBadRequestException(BlogException e) {
        String message = extractMessage(e);
        LOGGER.error("Error: {}", message);
        return new ErrorResponse("Invalid request.", message, "");
    }

    private String extractMessage(Exception e) {
        String message = "";
        if (null != e.getMessage()) {
            message = e.getMessage();
        } else {
            // does it have a cause?
            if (null != e.getCause()) {
                if (null != e.getCause().getMessage()) {
                    message = e.getCause().getMessage();
                }
            }
        }
        return message;
    }
}
