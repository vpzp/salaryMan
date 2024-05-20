package com.example.demo.Post;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
class PostServiceTest {
    @Autowired
    PostService postService;

    @Test
    void create() {
        postService.create("샐러리맨 시스템 이용 방법", "이용 방법은 다음과 같습니다", "공지사항");
        postService.create("샐러리맨 시스템 안정화 점검 공지", "@월 @일 @시부터 @월 @일 @시까지 점검이 있을 예정입니다.", "공지사항");

        postService.create("급여 설정은 어떻게 하나요 ?", "", "질문");
        postService.create("직원 관리자 권한을 부여 받으려면 어떻게 하나요 ?", "", "질문");
        postService.create("급여 명세서를 인쇄 할 수 있나요 ?", "", "질문");
        postService.create("개인정보 수정 및 저장은 어디서 할 수 있나요 ?", "","질문");
    }
}