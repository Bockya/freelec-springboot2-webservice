package com.rhg1209.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/*
* @SpringBootApplicaion
*   - 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성 자동 설정
*   - 이 위치부터 설정을 읽음
*   - 프로젝트의 최상단에 위치
*
* SpringApplicaion.run
*   - 내장 WAS(Web Applicaion Server) 실행
* */