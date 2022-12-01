package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Board;
import com.shopping.snack.db.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class BoardDTO {

    private String title;
    private String content;

    public Board boardCreate(Member member){
        Board board = new Board();
        board.setBoardDay(LocalDate.now());
        board.setBoardWriter(member);
        board.setBoardContent(this.content);
        board.setBoardTitle(this.title);
        board.setBoardViews(0);
        board.setBoardDisplay(Boolean.TRUE);
        return board;
    }
}
