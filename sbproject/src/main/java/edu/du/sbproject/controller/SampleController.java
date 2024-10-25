package edu.du.sbproject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/sample/")
public class SampleController {

    @GetMapping("/accessDenied")
    public void accessDenied() {}

    @GetMapping("/admin")
    public void admin() {
        log.info("....................admin....................");
    }

    @GetMapping("/member")
    public void member() {
        log.info("....................member....................");
    }

    @GetMapping("/all")
    public void all() {
        log.info("....................all....................");
    }

    @GetMapping("/login")
    public void login(String errorCode, String logout) {
        log.info("login 페이지..........");
        if (logout != null) {
            log.info("user logout..........");
        }
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/sample/login?logout";
    }
}
