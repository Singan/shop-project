package com.shopping.snack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class ProductController {
    @GetMapping("/product")
    public String productList(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        System.out.println("index Get");
        return "index.html";
    }
    @GetMapping("/product/detail")
    public String productDetail(HttpServletRequest request,String no){
        HttpSession httpSession = request.getSession();
        System.out.println("index Get");
        return "/html/product/product_detail.html";
    }
    @GetMapping("/member/order")
    public String product_order(){
        System.out.println("프로필");
        return "/html/member/order_list.html";
    }
}
