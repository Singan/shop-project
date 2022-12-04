package com.shopping.snack.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_no")
    private Long productNo;
    @Column(name = "product_thumbnail"  ,columnDefinition = "MEDIUMTEXT")
    private String productThumbnail;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_detail" ,columnDefinition = "LONGTEXT")
    private String productDetail;
    @Column(name = "product_count")
    private Long productCount;
    @Column(name = "product_type")
    private Long productType;
    @Column(name = "product_price")
    private Long productPrice;

    @Column(name = "product_discount")
    private Long productDiscount;

    @Column(name = "product_cate")
    private String productCate;

    @Column(name = "product_view")
    private Boolean productView;

    @Column(name="product_short_des")
    private String productShort;


    @OneToMany(mappedBy = "replyProduct" ,fetch =FetchType.LAZY)
    private List<Reply> replyList = new ArrayList<>();
}
