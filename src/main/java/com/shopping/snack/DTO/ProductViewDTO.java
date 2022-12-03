package com.shopping.snack.DTO;

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
    private List<Reply> replyList;



}
