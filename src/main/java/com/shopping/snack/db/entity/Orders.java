package com.shopping.snack.db.entity;

import com.shopping.snack.db.enumClass.OrdersStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne(fetch = FetchType.LAZY )
    private Member ordersMember;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders" ,  cascade = {CascadeType.ALL,CascadeType.MERGE,CascadeType.PERSIST})
    private List<OrdersItem> ordersItems = new ArrayList<>();

    @Column(name = "orders_phone")
    private String ordersPhone;
    @Column(name  ="orders_detail_address")
    private String ordersDetailAddress;
    @Column(name = "orders_address")
    private String ordersAddress;
    @Column(name  ="orders_zone_code")
    private Integer ordersZoneCode;
    @Column(name = "orders_name")
    private String ordersName;
    @Column(name = "orders_date")
    private LocalDateTime ordersDate;

}
