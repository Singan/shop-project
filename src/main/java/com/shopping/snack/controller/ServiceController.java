package com.shopping.snack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ServiceController {
    @GetMapping("/member/basket")
    public String basket(){
        System.out.println("basket");
        return "/html/service/basket";
    }
    @GetMapping("/notice")
    public String notice(){
        System.out.println("notice");
        return "/html/service/notice";
    }

}
