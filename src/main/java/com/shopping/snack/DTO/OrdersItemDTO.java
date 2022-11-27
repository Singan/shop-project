package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.OrdersItem;
import com.shopping.snack.db.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdersItemDTO {
    private Long orderItemNo;
    private Integer orderCount;

    public OrdersItem getOrdersItem(){
        OrdersItem ordersItem = new OrdersItem();
        Product product = new Product();
        product.setProductNo(orderItemNo);
        ordersItem.setProduct(product);
        ordersItem.setCount(orderCount);
        return ordersItem;
    }
}
