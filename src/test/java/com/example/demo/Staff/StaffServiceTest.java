package com.example.demo.Staff;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
class StaffServiceTest {
    @Autowired
    StaffService staffService;

    @Test
    void create() {
        staffService.create("테스트1", "사장", "RPA 개발 부서", "하나은행",
                "3333-123-1234567", "01012345678", "알투소프트");
        for (int i = 0 ; i < 2 ; i++){
            staffService.create("테스트"+ i, "전무", "RPA 개발 부서", "하나은행",
                    "3333-123-1234567", "01012345678", "알투소프트");
        }
        for (int i = 0 ; i < 3 ; i++){
            staffService.create("테스트"+ i, "이사", "RPA 개발 부서", "하나은행",
                    "3333-123-1234567", "01012345678", "알투소프트");
        }
        for (int i = 0 ; i < 5 ; i++){
            staffService.create("테스트"+ i, "과장", "RPA 개발 부서", "하나은행",
                    "3333-123-1234567", "01012345678", "알투소프트");
        }
        for (int i = 0 ; i < 5 ; i++){
            staffService.create("테스트"+ i, "대리", "RPA 개발 부서", "하나은행",
                    "3333-123-1234567", "01012345678", "알투소프트");
        }
        for (int i = 0 ; i < 10 ; i++){
            staffService.create("테스트"+ i, "사원", "RPA 개발 부서", "하나은행",
                    "3333-123-1234567", "01012345678", "알투소프트");
        }
        for (int i = 0 ; i < 10 ; i++){
            staffService.create("테스트"+ i, "인턴", "RPA 개발 부서", "하나은행",
                    "3333-123-1234567", "01012345678", "알투소프트");
        }

    }
}