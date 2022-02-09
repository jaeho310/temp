package com.example.sample.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Data
@EntityListeners(AuditingEntityListener.class) // 신경안쓰셔도 됩니다.
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Timestamp time;
    public String alarmType;
    public Integer level;

    // public Integer thresholdID;


}
