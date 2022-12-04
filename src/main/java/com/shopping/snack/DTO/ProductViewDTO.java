package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Product;
import com.shopping.snack.db.entity.Reply;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class ProductViewDTO {

    private Long productNo;
    private String productThumbnail;
    private String productName;
    private String productDetail;
    private Long productCount;
    private Long productType;
    private Long productPrice;
    private Long productDiscount;
    private String productCate;
    private Boolean productView;
    private String productShort;
    private List<ReplyViewDTO> replyList;
    public ProductViewDTO(Product product){
        this.productNo = product.getProductNo();
        this.productThumbnail = product.getProductThumbnail();
        this.productName = product.getProductName();
        this.productDetail = product.getProductDetail();
        this.productCount = product.getProductCount();
        this.productType = product.getProductType();
        this.productPrice = product.getProductPrice();
        this.productDiscount = product.getProductDiscount();
        this.productCate = product.getProductCate();
        this.productView = product.getProductView();
        this.productShort = product.getProductShort();

    }


}
