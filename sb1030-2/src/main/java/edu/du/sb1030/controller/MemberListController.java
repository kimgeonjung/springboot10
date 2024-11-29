package edu.du.sb1030.controller;

import edu.du.sb1030.spring.Member;
import edu.du.sb1030.spring.MemberDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberListController {
    private final MemberDao memberDao;

    @RequestMapping("/members")
    public String List(@ModelAttribute("cmd") ListCommand listCommand, Model model, Errors errors) {
        if(errors.hasErrors()) {
            return "member/memberList";
        }
        if (listCommand.getFrom() != null && listCommand.getTo() != null) {
            List<Member> members = memberDao.selectByRegdate(listCommand.getFrom(), listCommand.getTo());
            model.addAttribute("members", members);
        }
        return "member/memberList";
    }
}
