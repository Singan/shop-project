package com.shopping.snack.controller;

import com.shopping.snack.DTO.BoardDTO;
import com.shopping.snack.DTO.ProductInsertDTO;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.repository.BoardRepository;
import com.shopping.snack.db.service.BoardService;
import com.shopping.snack.db.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final BoardService boardService;
    private final HttpServletRequest request;
    private final ProductService productService;

    @GetMapping("/notice/insert")
    public String goNoticeInsert(){
        Member member =(Member)request.getSession().getAttribute("user");
        if(member==null){
            return "redirect:/login";
        }
        return "/html/admin/notice_insert.html";
    }
    @PostMapping("/notice/insert")
    public String noticeInsert( BoardDTO boardDTO){
        Member member =(Member)request.getSession().getAttribute("user");
        Long no = boardService.boardInsert(boardDTO,member);
        return "redirect:/notice/detail?no="+no;
    }
    @GetMapping("/product/insert")
    public String goProductInsert(){
        System.out.println("loginHTML");
        Member member =(Member)request.getSession().getAttribute("user");
        if(member == null){
            return "redirect:/login";
        }
        return "/html/admin/product_insert.html";
    }

    @PostMapping("/product/insert")
    public String productInsert(ProductInsertDTO productInsertDTO ,  @RequestBody MultipartFile file){
        System.out.println("loginHTML");
        Member member =(Member)request.getSession().getAttribute("user");
        if(member == null){
            return "redirect:/login";
        }
        productService.productInsert(productInsertDTO);
        return "redirect:/";
    }
}
