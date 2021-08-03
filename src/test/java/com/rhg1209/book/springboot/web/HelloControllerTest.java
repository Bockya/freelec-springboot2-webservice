package com.rhg1209.book.springboot.web;

import org.apache.catalina.security.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
})
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}

/*
 * 1. @ExtendWith(SpringExtesion.class)
 *   - 스프링 부트와 JUnit 사이에 연결자 역할
 *   - 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴
 *   - SpringExtension라는 스프링 실행자 사용
 *
 * 2. @WebMvcTest
 *   - Web(Spring MVC)에 집중할 수 있는 어노테이션
 *   - @Controller, @ControllerAdvice 사용 가능
 *   - @Service, @Component, @Repository 사용 불가
 *
 * 3. @Autowired
 *   - 스프링이 관리하는 빈(Bean)을 주입받음
 *
 * 4. private MockMvc mvc
 *   - 웹 API를 테스트할 때 사용함
 *   - 스프링 MVC 테스트의 시작점
 *   - HTTP Get, Post 등에 대한 API 테스트를 할 수 있음
 *
 * 5. mvc.perform(get("/hello"))
 *   - MockMvc를 통해 /hello 주소로 HTTP Get 요청을 함
 *   - 체이닝이 지원되어 여러 검증 기능을 이어서 선언할 수 있음
 *
 * 6. .andExpect(status().isOk())
 *   - mvc.perform의 결과를 검증함
 *   - HTTP Header의 Status를 검증함
 *   - 200, 404, 500 등의 상태를 검증함
 *   - 여기선 OK 즉, 200인지 아닌지를 검증함
 *
 * 7. .andExpect(content().spring(hello))
 *   - mvc.perform의 결과를 검증함
 *   - Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증함
 *
 * 8. param
 *  - API 테스트할 때 사용될 요청 파라미터를 설정함
 *  - 단, 값은 String만 허용됨
 *
 * 9. jsonPath
 *  - JSON 응답값을 필드별로 검증할 수 있는 메서드
 *  - $를 기준으로 필드명을 명시함
 *  - 여기서는 name과 amout를 검증하니 $.name, $.amount로 검증함
 * */