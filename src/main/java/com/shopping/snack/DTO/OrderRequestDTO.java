package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Orders;
import com.shopping.snack.db.entity.OrdersItem;
import com.shopping.snack.db.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {
    private Long productNo;
    public Orders getOrders(){
      Orders orders = new Orders();
      OrdersItem ordersItem = new OrdersItem();
      Product product = new Product();
      product.setProductNo(productNo);
      ordersItem.setProduct(product);
      ordersItem.setCount(1);

      orders.getOrdersItems().add(ordersItem);
      return orders;
    };
}
