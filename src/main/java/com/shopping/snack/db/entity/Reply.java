package com.shopping.snack.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Reply {
    @Id
    @Column(name = "reply_no")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long replyNo;

    @JoinColumn(name = "reply_writer")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member replyWriter;




    @Column(name = "reply_day")
    private LocalDate replyDay;

    @Column(name = "reply_content" , columnDefinition = "LONGTEXT")
    private String replyContent;
}
