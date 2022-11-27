package com.shopping.snack.controller;

import com.shopping.snack.DTO.OrderViewDTO;
import com.shopping.snack.db.entity.Product;
import com.shopping.snack.db.enumClass.Category;
import com.shopping.snack.db.enumClass.SpecialProduct;
import com.shopping.snack.db.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/product")
    public String productList(HttpServletRequest request){
        System.out.println("index Get");
        return "index.html";
    }
    @GetMapping("/product/detail")
    public String productDetail(Model model,HttpServletRequest request, Long no){
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

    @GetMapping("/product/order")
    public String orderGo(Model model, Long[] no ,@RequestParam(defaultValue = "1") Integer[] count){
        List<Product> productList= productService.productFind(no);
        List<Integer> countList = Arrays.asList(count);
        if(countList.stream().equals(0)){
            throw new RuntimeException("0을 입력하지마세요");
        }

        List<OrderViewDTO> orderViewDTOList = productList.stream().map(product -> {
            return new OrderViewDTO(product);
        }).collect(Collectors.toList()) ;
        for (int i = 0 ;i<orderViewDTOList.size();i++){
            orderViewDTOList.get(i).setProductCount(count[i]);
        }
        model.addAttribute("productList",orderViewDTOList);
        return "/html/product/product_order.html";
    }
}
