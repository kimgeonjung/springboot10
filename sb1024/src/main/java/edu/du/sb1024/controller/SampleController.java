package edu.du.sb1024.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/sample/")
public class SampleController {

    @GetMapping("/accessDenied")
    public void accessDenied() {}

    @GetMapping("/admin")
    public void admin() {
        log.info("admin....................");
    }

    @GetMapping("/member")
    public void member() {
        log.info("member....................");
    }

    @GetMapping("/all")
    public void all() {
        log.info("all....................");
    }
}
