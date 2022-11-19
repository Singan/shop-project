package com.shopping.snack.controller;

import com.shopping.snack.DTO.BoardDTO;
import com.shopping.snack.DTO.ProductInsertDTO;
import com.shopping.snack.DTO.SessionMemberDTO;
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
import java.io.File;
import java.io.IOException;
import java.util.Base64;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final BoardService boardService;
    private final HttpServletRequest request;
    private final ProductService productService;

    @GetMapping("/notice/insert")
    public String goNoticeInsert(){
        SessionMemberDTO member =(SessionMemberDTO)request.getSession().getAttribute("user");
        if(member==null){
            return "redirect:/login";
        }
        return "/html/admin/notice_insert.html";
    }
    @PostMapping("/notice/insert")
    public String noticeInsert( BoardDTO boardDTO ,  @RequestBody MultipartFile image) throws IOException{
        SessionMemberDTO member =(SessionMemberDTO)request.getSession().getAttribute("user");
        String photoImg = null;
        System.out.println(image != null);
        System.out.println(image);
        System.out.println("왜안됨??");
        Long no = null;
        if (image != null) {
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] photoEncode = encoder.encode(image.getBytes());
            System.out.println(photoEncode);
            System.out.println("-=======================");
            photoImg = new String(photoEncode, "UTF8");
            System.out.println(photoImg.length());
            no = boardService.boardInsert(boardDTO,member.createMember(),photoImg);
        }else{
            no = boardService.boardInsert(boardDTO,member.createMember());
        }
        return "redirect:/notice/detail?no="+no;
    }
    @GetMapping("/product/insert")
    public String goProductInsert(){
        System.out.println("loginHTML");
        SessionMemberDTO member =(SessionMemberDTO)request.getSession().getAttribute("user");
        if(member == null){
            return "redirect:/login";
        }
        return "/html/admin/product_insert.html";
    }

    @PostMapping("/product/insert")
    public String productInsert(ProductInsertDTO productInsertDTO ,  @RequestBody MultipartFile image) throws IOException {
        System.out.println("loginHTML");
        SessionMemberDTO member =(SessionMemberDTO)request.getSession().getAttribute("user");
        if(member == null){
            return "redirect:/login";
        }
        String photoImg = null;
        if (image != null) {
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] photoEncode = encoder.encode(image.getBytes());
            photoImg = new String(photoEncode, "UTF8");
        }
        productService.productInsert(productInsertDTO,photoImg);
        return "redirect:/";
    }
}
