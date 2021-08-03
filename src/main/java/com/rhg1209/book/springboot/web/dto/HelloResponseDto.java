package com.rhg1209.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

}

/*
* 1. @Getter
*   - 선언된 모든 필드의 get 메서드를 생성함
*
* 2. @RequiredArgsConstructor
*   - 선언된 모든 final 필드가 포함된 생성자를 생성해 줌
*   - final이 없는 필드는 생성자에 포함되지 않음
* */
