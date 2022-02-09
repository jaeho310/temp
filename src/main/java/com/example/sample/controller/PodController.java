package com.example.sample.controller;

import com.example.sample.model.entity.Pod;
import com.example.sample.service.PodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/pods")
public class PodController {

    PodService podService;

    public PodController(PodService podService) {
        this.podService = podService;
    }

    @GetMapping("")
    public List<Pod> GetPods() {
        return podService.getPods();
    }
}
