package com.shopping.snack.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
    @GetMapping("/member/join")
    public String joinHtml(){
        System.out.println("조인");
        return "join.html";
    }
}
