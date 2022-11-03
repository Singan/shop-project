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
    public String index(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        System.out.println("index Get");
        return "index.html";
    }
    @GetMapping("/loginCheck")
    @ResponseBody
    public Object indexPost(HttpServletRequest request){
        System.out.println("로그인 체크");
        return request.getSession().getAttribute("user");
    }
    @GetMapping("/login")
    public String loginHtml(){
        System.out.println("loginHTML");
        return "./html/login.html";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("user",null);
        System.out.println("로그아웃");
        return "/";
    }
    @PostMapping("/login")
    @ResponseBody
    public Member login(HttpServletRequest request, @RequestBody LoginDTO loginDTO){
        Member member = new Member();
        member.setMemberId(loginDTO.getId());

        Member findMember = memberService.findMember(member);
        System.out.println(findMember.getMemberPassword().equals(loginDTO.getPwd()));
        if(findMember.getMemberPassword().equals(loginDTO.getPwd())){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user",findMember);

            return findMember;
        };
        return null;
    }

}
