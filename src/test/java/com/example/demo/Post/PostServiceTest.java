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
        postService.create("샐러리맨 시스템 이용 방법", "권한에 따라 볼 수 있는 글이 다릅니다.\n" +
                "관리자의 경우 '급여 관리'를 통해 회사 내 직원들의 급여를 설정할수 있습니다\n" +
                "또한 '급여 명세서'를 통해 직원들의 급여 계산식을 볼 수 있습니다.\n" +
                "일반 사용자의 경우 자신의 급여 명세서만 확인할 수 있습니다.", "공지사항");
        postService.create("샐러리맨 시스템 안정화 점검 공지", "@월 @일 @시부터 @월 @일 @시까지 점검이 있을 예정입니다.", "공지사항");

        postService.create("급여 명세서 계산식은 어떻게 되나요 ?", "급여 명세서 계산식은 다음과 같습니다.\n" +
                "국민연금 비율 : 4.5%\n" +
                "건강보험 비율 : 3.498%\n" +
                "장기요양보험 비율 : 12.81%\n" +
                "고용보험 비율 : 0.8%\n" +
                "노동조합비 비율 : 1%\n" +
                "배우자 수당: 매월 50,000원\n" +
                "자녀 수당: 자녀 1인당 매월 30,000원\n" +
                "부양가족 수당: 부모 1인당 매월 20,000원\n" +
                "연장근로수당, 야간근로수당, 휴일근로수당의 비율 : 전부 1.5%", "질문");
        postService.create("직원 관리자 권한을 부여 받으려면 어떻게 하나요 ?", "", "질문");
        postService.create("급여 명세서를 인쇄 할 수 있나요 ?", "", "질문");
        postService.create("개인정보 수정 및 저장은 어디서 할 수 있나요 ?", "","질문");
    }
}