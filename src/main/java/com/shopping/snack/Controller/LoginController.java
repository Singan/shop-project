package com.shopping.snack.controller;

import com.shopping.snack.DTO.LoginDTO;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final MemberService memberService;
    @GetMapping("/")
    public String index(){
        System.out.println("인덱스접속");
        return "index.html";
    }
    @GetMapping("/login")
    public String loginHtml(){
        System.out.println("loginHTML");
        return "./html/login.html";
    }
    @PostMapping("/login")
    @ResponseBody
    public Member login(@RequestBody LoginDTO loginDTO){
        Member member = new Member();
        member.setMemberId(loginDTO.getId());
        return memberService.findMember(member);
    }

}
