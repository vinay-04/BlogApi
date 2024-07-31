package io.vr.blog.BlogApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vr.blog.BlogApi.model.BlogModel;
import io.vr.blog.BlogApi.service.BlogService;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public ResponseEntity<List<BlogModel>> getBlogs() {
        return ResponseEntity.ok(blogService.getBlogs());
    }

    @PostMapping("/create-blog")
    public ResponseEntity<BlogModel> createBlog(@RequestBody BlogModel blog) {
        BlogModel createdBlog = blogService.createBlog(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBlog);

    }

}
