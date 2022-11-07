package com.shopping.snack.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_no")
    private Long productNo;
    @Column(name = "product_thumbnail")
    private String productThumbnail;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_detail")
    private String productDetail;
    @Column(name = "product_count")
    private Long productCount;
    @Column(name = "product_type")
    private Long productType;
    @Column(name = "product_price")
    private Long productPrice;
}