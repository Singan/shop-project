package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Board;
import com.shopping.snack.db.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class BoardDTO {

    private String title;
    private String content;

    BoardDTO(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Board boardCreate(Member member){
        Board board = new Board();
        board.setBoardDay(LocalDate.now());
        board.setBoardWriter(member);
        board.setBoardContent(this.content);
        board.setBoardTitle(this.title);
        return board;
    }
}
