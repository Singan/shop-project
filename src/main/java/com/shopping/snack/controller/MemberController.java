package com.shopping.snack.controller;

import com.shopping.snack.DTO.*;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.repository.MemberRepository;
import com.shopping.snack.db.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final HttpServletRequest httpServletRequest;
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
    public String profile(MultipartFile image, ProfileUpdateDTO updateDTO) throws IOException {
        SessionMemberDTO sessionMember = (SessionMemberDTO)httpServletRequest.getSession().getAttribute("user");
        String photoImg = null;
        if (!image.isEmpty()) {
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] photoEncode = encoder.encode(image.getBytes());
            photoImg = new String(photoEncode, "UTF8");
        }
        updateDTO.setNo(sessionMember.getMemberNo());
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
        String res = memberService.findMemberId(findId.getName());
        return res;
    }
    @PostMapping("/find/pw")
    public String findPw(@RequestBody FindIdDTO findId){
        return "/html/member/find_pwd.html";
    }
}
