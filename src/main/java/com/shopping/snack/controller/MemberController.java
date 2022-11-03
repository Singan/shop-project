package com.shopping.snack.controller;

import com.shopping.snack.DTO.JoinDTO;
import com.shopping.snack.DTO.LoginDTO;
import com.shopping.snack.db.repository.MemberRepository;
import com.shopping.snack.db.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/member/join")
    public String joinHtml(){
        System.out.println("조인");
        return "html/join.html";
    }

    @PostMapping("/member/join")
    @ResponseBody
    public Long join(@RequestBody JoinDTO joinDTO){
        System.out.println("회원가입 post");
        return memberService.join(joinDTO.getMember());
    }
}
