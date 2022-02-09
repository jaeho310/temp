package com.example.sample.model.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class) // 신경안쓰셔도 됩니다.
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NonNull
    public String name;
}
