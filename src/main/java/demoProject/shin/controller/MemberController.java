package demoProject.shin.controller;

import demoProject.shin.dto.MemberDto;
import demoProject.shin.repository.MemberRepository;
import demoProject.shin.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/join") // @RequestMapping에 의해 member/join이 됨
    public String showJoinForm(){
        return "member/joinForm";
    }
    @PostMapping("/join")
    public String addMember(@Validated @ModelAttribute MemberDto memberDto, BindingResult bindingResult){


    }

    @GetMapping("/modify")
    public String modify(){
        return "member/modify";
    }
    @PostMapping("/modify")
    public String modify(@){

    }



}
