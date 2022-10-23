package com.shopping.snack.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/")
    public String index(){
        System.out.println("인덱스접속");
        return "index.html";
    }
}
