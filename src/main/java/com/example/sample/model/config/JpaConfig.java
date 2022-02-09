package com.example.sample.model.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 전체 다 신경안쓰셔도 됩니다.
@Configuration
@EnableJpaAuditing
public class JpaConfig {

}
