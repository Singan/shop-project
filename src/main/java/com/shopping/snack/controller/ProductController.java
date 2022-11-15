package com.shopping.snack.controller;

import com.shopping.snack.db.enumClass.Category;
import com.shopping.snack.db.enumClass.SpecialProduct;
import com.shopping.snack.db.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/product")
    public String productList(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        System.out.println("index Get");
        return "index.html";
    }
    @GetMapping("/product/detail")
    public String productDetail(Model model,HttpServletRequest request, Long no){
        HttpSession httpSession = request.getSession();
        model.addAttribute("product", productService.productFind(no));
        return "/html/product/product_detail.html";
    }
    @GetMapping("/member/order")
    public String product_order(){
        System.out.println("주문정보");
        return "/html/member/order_list.html";
    }
    @GetMapping("/product/category")
    public String categorySelect(String category,Model model) throws IllegalArgumentException{
        model.addAttribute("category",category);
        SpecialProduct[] sp = SpecialProduct.values();
        Category[] ct = Category.values();
        for (SpecialProduct s:sp) {
            if(s.name().equals(category)){
                return "/html/product/content_list.html";
            }
        }
        for (Category c:ct) {
            if(c.name().equals(category)){
                model.addAttribute("productList", productService.productList(category));
                return "/html/product/content_list.html";
            }
        }
        return "redirect:/";

    }
}
