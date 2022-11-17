package com.shopping.snack.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Basket {
    @Id
    @Column(name = "basket_no")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long basketNo;

    @JoinColumn(name="basket_member")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @JoinColumn(name="basket_product")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
