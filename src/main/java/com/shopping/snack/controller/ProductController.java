package com.shopping.snack.controller;

import com.shopping.snack.DTO.OrderViewDTO;
import com.shopping.snack.DTO.OrdersItemDTO;
import com.shopping.snack.DTO.SessionMemberDTO;
import com.shopping.snack.db.entity.Orders;
import com.shopping.snack.db.entity.Product;
import com.shopping.snack.db.enumClass.Category;
import com.shopping.snack.db.enumClass.SpecialProduct;
import com.shopping.snack.db.service.OrderService;
import com.shopping.snack.db.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final HttpServletRequest request;
    private final OrderService orderService;
    @GetMapping("/product")
    public String productList(){
        System.out.println("index Get");
        return "index.html";
    }
    @GetMapping("/product/detail")
    public String productDetail(Model model,HttpServletRequest request, Long no){
        model.addAttribute("product", productService.productFind(no));
        return "/html/product/product_detail.html";
    }
    @GetMapping("/member/order")
    public String product_order(Model model){
        SessionMemberDTO memberDTO = (SessionMemberDTO) request.getSession().getAttribute("user");

        List<Orders> ordersList = orderService.ordersList(memberDTO.createMember());
        model.addAttribute("ordersList",ordersList);
        for (Orders o:ordersList) {
            System.out.println(o.getOrdersNo());
        }
        return "/html/member/order_list.html";
    }
    @GetMapping("/product/category/get")
    @ResponseBody
    public List<Product> categoryGetContent(String category,Integer pageNo) throws IllegalArgumentException{

        Category[] ct = Category.values();
        System.out.println(category);
        if(SpecialProduct.인기상품.equals(category)){
                return productService.productPopularList(pageNo);
        }
        if(SpecialProduct.세일상품.equals(category)){
            return productService.productSaleList(pageNo);
        }
        for (Category c:ct) {
            if(c.name().equals(category)){
                System.out.println(productService.productList(category));
                return productService.productList(category);
            }
        }
        return null;
    }
    @GetMapping("/product/category")
    public String categorySelect(String category , Model model) throws IllegalArgumentException{
        model.addAttribute("category",category);
        return "/html/product/content_list.html";
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
