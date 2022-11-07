package com.shopping.snack.db.entity;

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
    private Long ordersStatus;
}
