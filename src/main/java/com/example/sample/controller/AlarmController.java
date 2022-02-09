package com.example.sample.controller;

import com.example.sample.model.entity.Alarm;
import com.example.sample.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;


// 이미 저장되어 있는 알람 가져오기
@RestController
@RequestMapping("/api/v1/alarms")
public class AlarmController {

  AlarmService alarmService;

  public AlarmController(AlarmService alarmService){
    this.alarmService = alarmService;
  }

  @GetMapping("/get")
  public List<Alarm> getAllAlarms(){
      return alarmService.getAllAlarms();
  }
}