package com.example.sample.service;

import com.example.sample.model.entity.Alarm;
import com.example.sample.repository.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmService {

    @Autowired
    AlarmRepository alarmRepository;

    // getAllAlarms, getAlarmList, getAlarms 중 하나로 통일하여 모든 메서드를 통일시켜서 개발합니다.
    public List<Alarm> getAllAlarms(){
        return alarmRepository.findAll();
    }

    // store라는 용어보다는 create or insert라는 용어로 통일합니다.
    public Alarm storeAlarm(Alarm alarms){
        Alarm alarm = Alarm.builder()
                .time(alarms.getTime())
                .level(alarms.getLevel())
                .alarmType(alarms.getAlarmType())
                .build();
        return alarmRepository.save(alarm);
    }
}
