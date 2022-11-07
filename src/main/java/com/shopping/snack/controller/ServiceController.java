package com.shopping.snack.controller;

import com.shopping.snack.db.entity.Board;
import com.shopping.snack.db.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
    public String noticeList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Board> boardList = boardService.boardList();
        modelAndView.addObject("boardList",boardList);
        return "/html/service/notice.html";
    }
    @GetMapping("/notice/detail")
    public String noticeDetail(Long no){
        ModelAndView modelAndView = new ModelAndView();
        Board board = boardService.boardDetail(no);
        modelAndView.addObject("board",board);
        return "/html/service/notice_detail.html";
    }
}
