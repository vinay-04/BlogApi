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

import io.vr.blog.BlogApi.model.UserModel;
import io.vr.blog.BlogApi.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userservice;

    UserController(UserService userservice) {
        this.userservice = userservice;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getUser() {
        return ResponseEntity.ok(userservice.getUser());
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
        UserModel createdUser = userservice.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
