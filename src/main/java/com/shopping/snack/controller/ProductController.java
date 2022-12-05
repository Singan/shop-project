package com.shopping.snack.controller;

import com.shopping.snack.DTO.*;
import com.shopping.snack.db.entity.Orders;
import com.shopping.snack.db.entity.Product;
import com.shopping.snack.db.entity.Reply;
import com.shopping.snack.db.enumClass.Category;
import com.shopping.snack.db.enumClass.SpecialProduct;
import com.shopping.snack.db.service.OrderService;
import com.shopping.snack.db.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "redirect:/";
    }
    @GetMapping("/product/detail")
    public String productDetail(Model model,HttpServletRequest request, Long no){
        model.addAttribute("product", productService.productFind(no));
        return "html/product/product_detail.html";
    }
    @GetMapping("/order/delete")
    public String orderDelete(Long no){

        orderService.orderDelete(no);
        return "redirect:/member/order";
    }
    @GetMapping("/member/order")
    public String productOrder(Model model){
        SessionMemberDTO memberDTO = (SessionMemberDTO) request.getSession().getAttribute("user");

        List<Orders> ordersList = orderService.ordersList(memberDTO.createMember());

        List<OrderViewDTO> orderViewDTOList = ordersList.stream().map(orders -> new OrderViewDTO(orders)).collect(Collectors.toList());
        model.addAttribute("ordersList",orderViewDTOList);

        return "html/member/order_list.html";
    }
    @GetMapping("/product/category/get")
    @ResponseBody
    public List<ProductViewDTO> categoryGetContent(String category,Integer pageNo) throws IllegalArgumentException{

        Category[] ct = Category.values();
        System.out.println(category);
        if(SpecialProduct.인기상품.equals(category)){
            
            List<ProductViewDTO> res=
                    productService.productPopularList(pageNo).stream().map(product -> new ProductViewDTO(product)).
                            collect(Collectors.toList());
            return res;
        }
        if(SpecialProduct.세일상품.equals(category)){
            System.out.println("세일상품 선택");
            List<ProductViewDTO> res=
                    productService.productSaleList(pageNo).stream().map(product -> new ProductViewDTO(product)).
                            collect(Collectors.toList());
            for (ProductViewDTO r:res) {
                System.out.println(r.getProductNo());
            }
            return res;
        }
        for (Category c:ct) {
            if(c.name().equals(category)){
                System.out.println("음");
                List<ProductViewDTO> res=
                        productService.productList(category,pageNo).stream().map(product -> new ProductViewDTO(product)).
                                collect(Collectors.toList());
                return res;
            }
        }
        return null;
    }
    @GetMapping("/product/category")
    public String categorySelect(String category , Model model) throws IllegalArgumentException{
        model.addAttribute("category",category);
        return "html/product/content_list.html";
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
        return "html/product/product_order.html";
    }

    @PostMapping("/product/reply")
    @ResponseBody
    public ReplyViewDTO replyInsert(@RequestBody ReplyInsertDTO replyInsertDTO){
        SessionMemberDTO memberDTO = (SessionMemberDTO) request.getSession().getAttribute("user");

        Reply reply = productService.replyInsert(replyInsertDTO,memberDTO);

        ReplyViewDTO replyViewDTO = new ReplyViewDTO(reply);
        replyViewDTO.setReplyWriter(memberDTO.getMemberName());
        return replyViewDTO;
    }

    @GetMapping("/product/delete")
    public String productDelete(Long no){
        productService.productDelete(no);
        return "redirect:/";
    }

    @GetMapping("/product/update")
    public String productUpdate(Model model,Long no){
        ProductInsertDTO p = new ProductInsertDTO(productService.productFind(no));
        model.addAttribute("product",p);
        return "html/admin/product_insert";
    }

    @PostMapping("/member/reply")
    @ResponseBody
    public List<MyReply> myReplyList(){
        SessionMemberDTO memberDTO = (SessionMemberDTO) request.getSession().getAttribute("user");

        return productService.myReplyList(memberDTO.createMember()).stream().map(reply -> new MyReply(reply)).collect(Collectors.toList());
    }
}
