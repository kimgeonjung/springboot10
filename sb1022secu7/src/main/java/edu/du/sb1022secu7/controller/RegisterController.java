package edu.du.sb1022secu7.controller;

import edu.du.sb1022secu7.exception.DuplicateMemberException;
import edu.du.sb1022secu7.service.MemberRegisterService;
import edu.du.sb1022secu7.vo.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register/")
@RequiredArgsConstructor
public class RegisterController {

    private final MemberRegisterService memberRegisterService;

    @GetMapping("/step1")
    public String handleStep1() {
        return "register/step1";
    }

    @PostMapping("/step2")
    public String handleStep2(
            @RequestParam(value = "agree", defaultValue = "false") Boolean agree,
            Model model) {
        if (!agree) {
            return "register/step1";
        }
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register/step2";
    }

    @GetMapping("/step2")
    public String handleStep2Get() {
        return "redirect:register/step1";
    }

    @PostMapping("/step3")
    public String handleStep3(RegisterRequest regReq) {
        try {
            memberRegisterService.regist(regReq);
            return "register/step3";
        } catch (DuplicateMemberException ex) {
            return "register/step2";
        }
    }
}
