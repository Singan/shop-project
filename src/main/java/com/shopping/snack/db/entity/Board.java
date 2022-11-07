package com.shopping.snack.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Board {
    @Id
    @Column(name = "board_no")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardNo;

    @JoinColumn(name = "board_writer")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member boardWriter;

    @Column(name = "board_day")
    private LocalDate boardDay;

    @Column(name = "board_content")
    private String boardContent;
}
