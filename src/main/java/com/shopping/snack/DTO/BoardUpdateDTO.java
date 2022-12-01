package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Board;
import com.shopping.snack.db.entity.Member;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class BoardUpdateDTO {
    private String title;
    private String content;
    private Long no;

}
