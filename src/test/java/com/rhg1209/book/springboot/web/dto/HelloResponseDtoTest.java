package com.rhg1209.book.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}

/*
* 1. assertThat
*   - assertj라는 테스트 검증 라이브러리의 검증 메서드
*   - 검증하고 싶은 대상을 메서드 인자로 받음
*   - 메서드 체이닝이 지원되어 isEqualTo와 같이 메서드를 이어서 사용 가능
*
* 2. isEqualTo
*   - assetj의 동등 비교 메서드
*   - assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공
* */

/*
* assertj(승) VS Jnit
*   - CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않음
*   - 자동완성이 좀 더 확실하게 지원됨
* */
