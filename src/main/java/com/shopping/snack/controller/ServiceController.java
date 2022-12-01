package com.shopping.snack.controller;

import com.shopping.snack.DTO.BasketDTO;
import com.shopping.snack.DTO.BasketRequest;
import com.shopping.snack.DTO.BoardUpdateDTO;
import com.shopping.snack.DTO.SessionMemberDTO;
import com.shopping.snack.db.entity.Basket;
import com.shopping.snack.db.entity.Board;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.service.BasketService;
import com.shopping.snack.db.service.BoardService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        SessionMemberDTO member = (SessionMemberDTO)httpServletRequest.getSession().getAttribute("user");
        model.addAttribute("basketList",member.getBasketList());

        return "/html/service/basket";
    }
    @GetMapping("/member/basketList")
    @ResponseBody
    public List<BasketDTO> basket(Model model){
        System.out.println("배스킷리스트 겟");
        SessionMemberDTO member = (SessionMemberDTO)httpServletRequest.getSession().getAttribute("user");
        for(BasketDTO b : member.getBasketList()){
            System.out.println(b.getProductNo());
        }
        return member.getBasketList();
    }
    @PostMapping("/member/basket")
    @ResponseBody
    public void basket(@RequestBody BasketRequest basketRequest){
        System.out.println("basket" + basketRequest.getNo());
        SessionMemberDTO member = (SessionMemberDTO) httpServletRequest.getSession().getAttribute("user");
        basketService.basketAppend(member,basketRequest.getNo());

        System.out.println("배스킷 post");

    }

    @GetMapping("/notice")
    public String noticeList(Model model){

        List<Board> boardList = boardService.boardList();
        model.addAttribute("boardList",boardList);
        return "/html/service/notice.html";
    }
    @GetMapping("/notice/delete")
    public String noticeDelete(Long no){
        boardService.boardDelete(no);
        System.out.println("삭제 들어옴");
        return "redirect:/notice";
    }
    @GetMapping("/notice/detail")
    public String noticeDetail(Model model,Long no){

        Board board = boardService.boardDetail(no);
        SessionMemberDTO member = (SessionMemberDTO) httpServletRequest.getSession().getAttribute("user");
        boolean b= false;
        if(member !=null){

            if(board.getBoardWriter().getMemberId().equals(member.getMemberId())){
                b=true;
            }

        }
        model.addAttribute("b",b);
        model.addAttribute("board",board);
        return "/html/service/notice_detail.html";
    }
    @GetMapping("/notice/update")
    public String noticeUpdate(Model model,Long no){

        Board board = boardService.boardDetail(no);
        model.addAttribute("board",board);
        return "/html/admin/notice_insert.html";
    }
    @PutMapping("/notice/update")
    @ResponseBody
    public Long noticeUpdate(@RequestBody BoardUpdateDTO boardUpdateDTO){

        boardService.boardUpdate(boardUpdateDTO);

        return boardUpdateDTO.getNo();
    }
}
