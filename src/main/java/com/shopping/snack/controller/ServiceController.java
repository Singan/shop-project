package com.shopping.snack.controller;

import com.shopping.snack.db.entity.Board;
import com.shopping.snack.db.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ServiceController {
    private final BoardService boardService;

    @GetMapping("/member/basket")
    public String basket(){
        System.out.println("basket");
        return "/html/service/basket";
    }
    @GetMapping("/notice")
    public String noticeList(Model model){

        List<Board> boardList = boardService.boardList();
        model.addAttribute("boardList",boardList);
        return "/html/service/notice.html";
    }
    @GetMapping("/notice/detail")
    public String noticeDetail(Model model,Long no){

        Board board = boardService.boardDetail(no);
        model.addAttribute("board",board);
        return "/html/service/notice_detail.html";
    }

    @GetMapping("/product/category")
    public String categorySelect(){


        return "/html/product/content_list.html";
    }
}
