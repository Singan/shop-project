package com.shopping.snack.db.entity;

import javax.persistence.*;

@Entity
public class Basket {
    @Id
    @Column(name = "basket_no")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long basket_no;

    @JoinColumn(name="basket_member")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @JoinColumn(name="basket_product")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
