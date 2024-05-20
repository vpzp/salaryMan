package com.example.demo.Company;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyServiceTest {
    @Autowired
    CompanyService companyService;

    @Test
    void create() {
        companyService.Create("알투소프트");
        companyService.Create("이디소프트");
    }
}