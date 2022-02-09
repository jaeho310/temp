package com.example.sample.service;

import com.example.sample.model.entity.User;
import com.example.sample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User insertUser(String name) {
        User user = User.builder().name(name).build();
        return userRepository.save(user);
    }
}
