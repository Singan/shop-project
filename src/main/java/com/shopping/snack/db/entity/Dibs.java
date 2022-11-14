package com.shopping.snack.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Dibs {
    @Id
    @Column(name = "dibs_no")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long dis_no;

    @JoinColumn(name="dibs_member")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @JoinColumn(name="dibs_product")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
