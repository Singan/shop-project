package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Basket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasketDTO {
    private Long productNo;
    private String productName;
    private Long productPrice;
    private String productThumbnail;
    private String productShort;
    public BasketDTO(Basket basket){
        this.productName = basket.getProduct().getProductName();
        this.productNo = basket.getProduct().getProductNo();
        this.productPrice = basket.getProduct().getProductPrice();
        this.productThumbnail = basket.getProduct().getProductThumbnail();
        this.productShort = basket.getProduct().getProductShort();
    }
}
