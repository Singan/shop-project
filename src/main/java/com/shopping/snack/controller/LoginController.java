package com.shopping.snack.controller;

import com.shopping.snack.DTO.LoginDTO;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public Member login(HttpServletRequest request, @RequestBody LoginDTO loginDTO){
        Member member = new Member();
        member.setMemberId(loginDTO.getId());

        Member findMember = memberService.findMember(member);
        if(findMember.getMemberPassword().equals(member.getMemberPassword())){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute(member.getMemberId(),member);
            return findMember;
        };
        return null;
    }

}
