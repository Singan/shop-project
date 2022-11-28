package com.shopping.snack.DTO;

import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.entity.Orders;
import com.shopping.snack.db.entity.OrdersItem;
import com.shopping.snack.db.entity.Product;
import com.shopping.snack.db.enumClass.OrdersStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class OrderRequestDTO {
    private List<OrdersItemDTO> ordersItems = new ArrayList<>();
    private String ordersPhone;
    private String ordersDetailAddress;
    private String ordersAddress;
    private Integer ordersZoneCode;
    private String ordersName;
    public Orders getOrders(){
      Orders orders = new Orders();
      orders.setOrdersItems(ordersItems.stream().map(ordersItemDTO -> {
          return ordersItemDTO.getOrdersItem();
      }).collect(Collectors.toList()));
      orders.setOrdersPhone(ordersPhone);
      orders.setOrdersAddress(ordersAddress);
      orders.setOrdersDetailAddress(ordersDetailAddress);
      orders.setOrdersZoneCode(ordersZoneCode);
      orders.setOrdersName(ordersName);
      orders.setOrdersDate(LocalDateTime.now());
      orders.setOrdersStatus(OrdersStatus.배송전);
      return orders;
    };
    public Orders getOrders(Member member){
        Orders orders =getOrders();
        orders.setOrdersMember(member);
        return orders;
    }
}
