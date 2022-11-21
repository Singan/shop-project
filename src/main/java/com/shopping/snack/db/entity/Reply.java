package com.shopping.snack.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Reply {
    @Id
    @Column(name = "reply_no")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long replyNo;
}
