package edu.du.sb1021_2;

import edu.du.sb1021_2.entity.Member;
import edu.du.sb1021_2.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class Sb10212ApplicationTests {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 입력테스트() {
        Member member = Member.builder()
                .name("홍길동")
                .email("hong@gildong.com")
                .password("12345")
                .regdate(LocalDateTime.now())
                .build();
        System.out.println(memberRepository.save(member));

    }
}
