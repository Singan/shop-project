package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Orders;
import com.shopping.snack.db.entity.OrdersItem;
import com.shopping.snack.db.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderRequestDTO {
    private List<OrdersItemDTO> ordersItems = new ArrayList<>();
    private String ordersPhone;
    private String ordersDetailAddress;
    private String ordersAddress;
    private Integer ordersZoneCode;
    private String ordersName;
    private LocalDateTime ordersDate;
    public Orders getOrders(){
      Orders orders = new Orders();
      return orders;
    };
}
