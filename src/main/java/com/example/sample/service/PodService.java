package com.example.sample.service;

import com.example.sample.model.entity.Pod;
import com.example.sample.repository.PodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PodService {

    @Autowired
    PodRepository podRepository;

    public List<Pod> getPods() {
//        Map<String, Object> response = new HashMap<>();
//        response.put("key", "value");
        return podRepository.findAll();
    }

}
