package com.example.sample.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@EntityListeners(AuditingEntityListener.class) // 신경안쓰셔도 됩니다.
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    // 신경안쓰셔도 됩니다.
    @CreatedDate
    private LocalDateTime createdAt;

    // 신경안쓰셔도 됩니다.
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
