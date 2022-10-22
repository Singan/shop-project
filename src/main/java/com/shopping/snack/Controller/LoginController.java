package com.shopping.snack.Controller;

import com.shopping.snack.DTO.LoginDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return "./html/login.html";
    }
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginDTO loginDTO){
        System.out.println("성공?");
        System.out.println(loginDTO.getId() + loginDTO.getPwd());
        return "./html/login.html";
    }
}
