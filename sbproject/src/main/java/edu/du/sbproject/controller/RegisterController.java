package edu.du.sbproject.controller;

import edu.du.sbproject.exception.DuplicateMemberException;
import edu.du.sbproject.service.MemberRegisterService;
import edu.du.sbproject.vo.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    public String handleStep3(RegisterRequest regReq, Errors errors) {
        new RegisterRequestValidator().validate(regReq, errors);
        try {
            memberRegisterService.regist(regReq);
            return "register/step3";
        } catch (DuplicateMemberException ex) {
            errors.reject("notMatchingIdPassword");
            return "register/step2";
        }
    }
}
