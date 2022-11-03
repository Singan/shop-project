package com.shopping.snack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
@RequiredArgsConstructor
public class IndexController {
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
}
