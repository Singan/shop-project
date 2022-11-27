package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
public class OrderViewDTO {
    private Long productNo;
    private String productThumbnail;
    private String productName;
    private String productDetail;
    private Integer productCount;
    private Long productPrice;
    private String productShort;
    public OrderViewDTO(Product product){
        productNo = product.getProductNo();
        productThumbnail = product.getProductThumbnail();
        productName = product.getProductName();
        productDetail = product.getProductDetail();
        productPrice = product.getProductPrice();
        productShort = product.getProductShort();
        productCount = 1;
    }
    public OrderViewDTO(Product product,Integer count){
        this(product);
        this.productCount = count;
    }

}
