package edu.du.sbproject.controller;

import edu.du.sbproject.entity.Member;
import edu.du.sbproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class BeginController {

    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String root() {
        return "/sample/all";
    }

//    @PostConstruct
//    public void init() {
//        Member member = Member.builder()
//                .id(1001L)
//                .username("kim")
//                .password(passwordEncoder().encode("1234"))
//                .email("kim@aaa.com")
//                .regdate(LocalDateTime.now())
//                .role("ADMIN")
//                .build();
//        memberRepository.save(member);
//    }

    private PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

}
