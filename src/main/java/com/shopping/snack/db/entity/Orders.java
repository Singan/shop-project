package com.shopping.snack.db.entity;

import com.shopping.snack.db.enumClass.OrdersStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Orders {
    @Id
    @Column(name = "orders_no")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ordersNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "orders_status")
    private OrdersStatus ordersStatus;

    @JoinColumn(name = "orders_member")
    @ManyToOne(fetch = FetchType.LAZY)
    private Member ordersMember;

    @JoinColumn(name="orders_items")
    @OneToOne(fetch = FetchType.LAZY)
    private OrdersItem ordersItem;
}
