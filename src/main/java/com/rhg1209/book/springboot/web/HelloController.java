package com.rhg1209.book.springboot.web;

import com.rhg1209.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

}

/*
 * 1. @RestController
 *   - 컨트롤러 -> JSON
 *
 * 2. @GetMapping
 *   - HTTP Method인 Get의 요청을 받을 수 있는 API 만들어 줌
 *   - /hello로 요청이 오면 hello 반환함
 *
 * 3. @RequestParam
 *  - 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
 *  - 외부에서 name (@RequestParam("name")) 이란 이름으로 넘긴 파라미터를 메서드 파라미터 name(String name)에 저장됨됨 * */
