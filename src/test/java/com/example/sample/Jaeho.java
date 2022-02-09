package com.example.sample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class Jaeho {

    @Test
    void check() {
        System.out.println("hello{\"123\"}");
    }

    @Test
    void versionCheck() {
        String springVersion = SpringVersion.getVersion();
        System.out.println("springVersion = " + springVersion);

        String springBootVersion = SpringBootVersion.getVersion();
        System.out.println("springBootVersion = " + springBootVersion);
    }

    // @Test 어노테이션을 이용하여 원하는 로직만 가볍게 돌릴 수 있습니다.
    @Test
    void restTemplateCheck() {
        // 헤더생성
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();
        // getForObject -> http header 설정 불가능 결과의 바디를 바로 객체에 매핑
        // getForEntity -> http header 설정 불가능 결과를 ResponseEntity로 받아옴(한번더 까야함)
        // exchange -> 헤더설정가능하고 웬만한거 다되는데 아규먼트가 조금 복잡함 -> 보통 이걸 많이 씁니다.

        // getForObject
        String response = restTemplate.getForObject("http://127.0.0.1:8085/api/users", String.class);
        System.out.println("response = " + response);
        // exchange
        ResponseEntity<String> exchange = restTemplate.exchange(
                "http://127.0.0.1:8085/api/users", // url
                HttpMethod.GET, // http 메서드
                new HttpEntity<String>(httpHeaders), // 헤더세팅
                String.class); // 받아올 데이터 타입

        System.out.println("exchange.getBody() = " + exchange.getBody());
    }
}
