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
import org.springframework.web.bind.annotation.*;
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
        return "html/admin/notice_insert.html";
    }
    @PostMapping("/notice/insert")
    @ResponseBody
    public Long noticeInsert(@RequestBody BoardDTO boardDTO) throws IOException{
        SessionMemberDTO member =(SessionMemberDTO)request.getSession().getAttribute("user");
        Long no = boardService.boardInsert(boardDTO,member.createMember());

        return no;
    }
    @GetMapping("/product/insert")
    public String goProductInsert(){
        System.out.println("loginHTML");
        SessionMemberDTO member =(SessionMemberDTO)request.getSession().getAttribute("user");
        if(member == null){
            return "redirect:/login";
        }
        return "html/admin/product_insert.html";
    }

    @PostMapping("/product/insert")
    @ResponseBody
    public Long productInsert(@RequestPart(value = "product") ProductInsertDTO productInsertDTO , @RequestPart(value = "image") MultipartFile image) throws IOException {
        System.out.println("인설트 들어옴");
        SessionMemberDTO member =(SessionMemberDTO)request.getSession().getAttribute("user");
        String photoImg = null;
        if (!image.isEmpty()) {
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] photoEncode = encoder.encode(image.getBytes());
            photoImg = new String(photoEncode, "UTF8");
        }
        if(productInsertDTO.getProductNo() ==null) {
            return productService.productInsert(productInsertDTO, photoImg);
        }else{
            if(!image.isEmpty()) {
                System.out.println("썸네일 변경");
                productInsertDTO.setProductThumbnail(photoImg);
            }
            return productService.productUpdate(productInsertDTO);
        }
    }
}
