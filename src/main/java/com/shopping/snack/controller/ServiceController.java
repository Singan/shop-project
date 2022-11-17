package com.shopping.snack.controller;

import com.shopping.snack.DTO.BasketRequest;
import com.shopping.snack.db.entity.Basket;
import com.shopping.snack.db.entity.Board;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.service.BasketService;
import com.shopping.snack.db.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ServiceController {
    private final BoardService boardService;
    private final BasketService basketService;

    private final HttpServletRequest httpServletRequest;
    @GetMapping("/member/basket")
    public String basketGo(Model model){
        System.out.println("basket");

        return "/html/service/basket";
    }
    @GetMapping("/member/basketList")
    @ResponseBody
    public List<Basket> basket(Model model){
        System.out.println("이게왜");
        Member member = (Member)httpServletRequest.getSession().getAttribute("user");
        return member.getBasketList();
    }
    @PostMapping("/member/basket")
    @ResponseBody
    public String basket(@RequestBody BasketRequest basketRequest){
        System.out.println("basket" + basketRequest.getNo());
        Member member = (Member) httpServletRequest.getSession().getAttribute("user");

        basketService.basketAppend(member,basketRequest.getNo());
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
}
