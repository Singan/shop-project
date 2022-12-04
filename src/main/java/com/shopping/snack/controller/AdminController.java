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
import org.springframework.web.bind.annotation.ResponseBody;
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
        return "/html/admin/product_insert.html";
    }

    @PostMapping("/product/insert")
    @ResponseBody
    public void productInsert(@RequestBody ProductInsertDTO productInsertDTO ,  @RequestBody MultipartFile image) throws IOException {
        SessionMemberDTO member =(SessionMemberDTO)request.getSession().getAttribute("user");
        String photoImg = null;
        if (!image.isEmpty()) {
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] photoEncode = encoder.encode(image.getBytes());
            photoImg = new String(photoEncode, "UTF8");
        }
        if(productInsertDTO.getProductNo() ==null) {
            productService.productInsert(productInsertDTO, photoImg);
        }else{
            if(!image.isEmpty()) {
                System.out.println("썸네일 변경");
                productInsertDTO.setProductThumbnail(photoImg);
            }
            productService.productUpdate(productInsertDTO);
        }
    }
}
