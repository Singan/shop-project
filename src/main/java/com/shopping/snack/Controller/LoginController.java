package com.shopping.snack.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/test")
    public String test(){
        System.out.println("고장났어요 고장");
        return "./html/test.html";
    }
    @GetMapping("/")
    public String index(){
        System.out.println("인덱스접속");
        return "index.html";
    }
    @GetMapping("/login")
    public String loginHtml(){
        System.out.println("loginHTML");
        return "login.html";
    }
}
