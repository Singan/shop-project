package com.shopping.snack.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OrdersItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ordersItem_no")
    private Long ordersItemNo;

    @JoinColumn(name = "ordersItem_order")
    @ManyToOne(fetch = FetchType.LAZY , cascade = {CascadeType.ALL,CascadeType.MERGE})
    private Orders orders;

    @JoinColumn(name = "ordersItem_product")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Column(name = "ordersItem_count")
    private Integer count;
    @Column(name = "ordersItem_discount")
    private Long disCount;
}
