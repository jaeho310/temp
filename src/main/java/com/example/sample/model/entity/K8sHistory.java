package com.example.sample.model.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class) // 신경안쓰셔도 됩니다.
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class K8sHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp time;

    private String kind;

    private String namespace;

    private String name;

    private String cmd;
}
