package com.example.sample.controller;

import com.example.sample.model.entity.User;
import com.example.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity getUsers() {
        List<User> response = userService.getUsers();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity insertUser(@RequestBody Map<String, Object> userData) {
        User response = userService.insertUser(userData.get("name").toString());
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}