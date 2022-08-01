package com.its.test;

import com.its.test.dto.TestDTO;
import com.its.test.service.TestService;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TestClass {
    @Autowired
    private TestService testService;

    @Test
    @Transactional
    @Rollback(value = true)
    public void saveTest() {

        TestDTO testDTO = new TestDTO("테스트제목", "테스트작성자", "테스트내용");
        Long savedId = testService.save(testDTO);
        TestDTO findDTO = testService.findById(savedId);
        assertThat(testDTO.getTestTile()).isEqualTo(findDTO.getTestTile());
    }

    @Test
    @Transactional
    @DisplayName("findAll 테스트")
    public void findAllTest() {
        /**
         * 1. 3개의 테스트 데이터 저장
         * 2. findAll 호출
         * 3. 호출한 크기가 3인지를 판다
         * 4. 3이면 테스트 통과, 아니면 테스트 실패
         */
        // 3개의 테스트 데이터를 저장해봅시다. 반복문을 써서
    }

}


