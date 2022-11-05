package com.shopping.snack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class AdminController {
    @GetMapping("/notice/insert")
    public String noticeInsert(){
        System.out.println("loginHTML");
        return "/html/admin/notice_insert.html";
    }

}
