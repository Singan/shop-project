package com.shopping.snack.controller;

import com.shopping.snack.DTO.BoardDTO;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.repository.BoardRepository;
import com.shopping.snack.db.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private final BoardService boardService;

    @GetMapping("/notice/insert")
    public String goNoticeInsert(HttpServletRequest request){
        Member member =(Member)request.getSession().getAttribute("user");
        if(member==null){
            return "/login";
        }
        return "/html/admin/notice_insert.html";
    }
    @PostMapping("/notice/insert")
    public String noticeInsert(HttpServletRequest request, BoardDTO boardDTO){
        Member member =(Member)request.getSession().getAttribute("user");
        Long no = boardService.boardInsert(boardDTO,member);
        return "redirect:/notice/detail?no="+no;
    }
    @GetMapping("/product/insert")
    public String productInsert(){
        System.out.println("loginHTML");
        return "/html/admin/notice_insert.html";
    }
}
