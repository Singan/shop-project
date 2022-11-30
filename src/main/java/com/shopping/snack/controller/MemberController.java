package com.shopping.snack.controller;

import com.shopping.snack.DTO.FindIdDTO;
import com.shopping.snack.DTO.JoinDTO;
import com.shopping.snack.DTO.LoginDTO;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.repository.MemberRepository;
import com.shopping.snack.db.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/member/join")
    public String joinHtml(){
        System.out.println("조인");
        return "/html/member/join.html";
    }

    @PostMapping("/member/join")
    @ResponseBody
    public Long join(@RequestBody JoinDTO joinDTO){
        System.out.println("회원가입 post");
        return memberService.join(joinDTO.getMember());
    }

    @GetMapping("/member/find")
    public String findIdOrPwd(){
        System.out.println("아이디 비밀번호 찾기");
        return "/html/member/find_id_password.html";
    }

    @GetMapping("/member/profile")
    public String profileGo(){
        return "/html/member/profile.html";
    }

    @PostMapping("/member/profile")
    public String profile(){
        return "/html/member/profile.html";
    }
    @GetMapping("/member/mypage")
    public String mypageGo(){

        return "/html/member/mypage.html";
    }

    @PostMapping("/member/mypage")
    public String mypage(){
        return "/html/member/mypage.html";
    }

    @PostMapping("/member/check")
    @ResponseBody
    public Boolean idCheck(@RequestBody LoginDTO loginDTO){
        Boolean flag = memberService.findMember(loginDTO.getId());
        return flag;
    }

    @GetMapping("/find/id")
    public String findIdGo(){
        return "/html/member/find_id.html";
    }
    @GetMapping("/find/pw")
    public String findPwGo(){
        return "/html/member/find_pwd.html";
    }


    @PostMapping("/find/id")
    @ResponseBody
    public String findId(@RequestBody FindIdDTO findId){
        System.out.println(findId.getName());
        System.out.println(memberService.findMemberId(findId.getName()));
        return memberService.findMemberId(findId.getName());
    }
    @PostMapping("/find/pw")
    public String findPw(@RequestBody FindIdDTO findId){
        return "/html/member/find_pwd.html";
    }
}
