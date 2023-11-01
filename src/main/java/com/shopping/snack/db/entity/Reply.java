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



    @JoinColumn(name = "reply_product")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product replyProduct;


    @Column(name = "reply_day")
    private LocalDate replyDay;

    @Column(name = "reply_image",columnDefinition = "LONGTEXT")
    private String replyImage;

    @Column(name = "reply_content")
    private String replyContent;
}
