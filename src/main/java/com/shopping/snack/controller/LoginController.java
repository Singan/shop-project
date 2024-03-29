package com.shopping.snack.controller;

import com.shopping.snack.DTO.LoginDTO;
import com.shopping.snack.DTO.SessionMemberDTO;
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

    @GetMapping("/login")
    public String loginHtml(){
        System.out.println("loginHTML");
        return "html/member/login.html";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("user",null);
        System.out.println("로그아웃");
        return "redirect:/";
    }
    @PostMapping("/login")
    @ResponseBody
    public SessionMemberDTO login(HttpServletRequest request, @RequestBody LoginDTO loginDTO){
        Member findMember = memberService.findMember(loginDTO);
        if(findMember==null){
            throw new RuntimeException("없는 아이디입니다.");
        }
        System.out.println(findMember.getMemberPassword().equals(loginDTO.getPwd()));
        if(findMember.getMemberPassword().equals(loginDTO.getPwd())){
            HttpSession httpSession = request.getSession();
            SessionMemberDTO sessionMemberDTO =new SessionMemberDTO(findMember);
            httpSession.setAttribute("user",sessionMemberDTO);
            
            return sessionMemberDTO ;
        }else {
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        }

    }


}
