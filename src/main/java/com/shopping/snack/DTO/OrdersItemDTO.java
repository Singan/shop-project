package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.OrdersItem;
import com.shopping.snack.db.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersItemDTO {
    private Long productNo;
    private Integer count;
    private String productThumbnail;
    private String productName;
    private String productShort;
    private Long productPrice;
    private Long productDiscount;
    public OrdersItem getOrdersItem(){
        OrdersItem ordersItem = new OrdersItem();
        Product product = new Product();
        product.setProductNo(productNo);
        ordersItem.setProduct(product);
        ordersItem.setCount(count);
        return ordersItem;
    }

    public OrdersItemDTO(OrdersItem ordersItem){
        this.productNo = ordersItem.getOrdersItemNo();
        this.productThumbnail = ordersItem.getProduct().getProductThumbnail();
        this.productShort = ordersItem.getProduct().getProductShort();
        this.productName = ordersItem.getProduct().getProductName();
        this.productPrice = ordersItem.getProduct().getProductPrice();
        this.count = ordersItem.getCount();
    }
    public OrdersItemDTO(){

    }
}
