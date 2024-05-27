package com.example.demo.Staff;

import com.example.demo.Company.CompanyService;
import com.example.demo.SiteUser.SiteUserService;
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
    @Autowired
    SiteUserService siteUserService;
    @Autowired
    CompanyService companyService;

    @Test
    void create() {
        for (int i = 0 ; i < 2 ; i++){
            siteUserService.create("wjsan"+ i, "q1w2e3r4","알투소프트","전무"+ i , "01012345678", "전무",
                    "RPA 개발 부서", "wjsan"+ i + "naver.com", "하나은행", "3333-123-1234567", "사용자",
                    false, 0);
        }
        for (int i = 0 ; i < 3 ; i++){
            siteUserService.create("dltk"+ i, "q1w2e3r4","알투소프트","이사"+ i , "01012345678", "이사",
                    "RPA 개발 부서", "dltk"+ i + "naver.com", "하나은행", "3333-123-1234567", "사용자",
                    false, 0);
        }
        for (int i = 0 ; i < 5 ; i++){
            siteUserService.create("rhkwkd"+ i, "q1w2e3r4","알투소프트","과장"+ i , "01012345678", "과장",
                    "RPA 개발 부서", "rhkwkd"+ i + "naver.com", "하나은행", "3333-123-1234567", "사용자",
                    false, 0);
        }
        for (int i = 0 ; i < 5 ; i++){
            siteUserService.create("eofl"+ i, "q1w2e3r4","알투소프트","대리"+ i , "01012345678", "대리",
                    "RPA 개발 부서", "eofl"+ i + "naver.com", "하나은행", "3333-123-1234567", "사용자",
                    false, 0);
        }
        for (int i = 0 ; i < 10 ; i++){
            siteUserService.create("tkdnjs"+ i, "q1w2e3r4","알투소프트","사원"+ i , "01012345678", "사원",
                    "RPA 개발 부서", "tkdnjs"+ i + "naver.com", "하나은행", "3333-123-1234567", "사용자",
                    false, 0);
        }
        for (int i = 0 ; i < 10 ; i++){
            siteUserService.create("dlsxjs"+ i, "q1w2e3r4","알투소프트","인턴"+ i , "01012345678", "인턴",
                    "RPA 개발 부서", "dlsxjs"+ i + "naver.com", "하나은행", "3333-123-1234567", "사용자",
                    false, 0);
        }

    }
}