package com.shopping.snack.controller;

import com.shopping.snack.db.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
@RequiredArgsConstructor
public class IndexController {

    private final ProductService productService;
    private final HttpServletRequest request;
    @GetMapping("/")
    public String index( Model model){
        System.out.println("index Get");

        model.addAttribute("productList",productService.productList());
        return "index.html";
    }
    @GetMapping("/loginCheck")
    @ResponseBody
    public Object indexPost(){
        System.out.println("로그인 체크");
        return request.getSession().getAttribute("user");
    }
}
