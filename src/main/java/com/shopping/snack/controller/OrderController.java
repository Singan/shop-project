package com.shopping.snack.controller;

import com.shopping.snack.DTO.OrderRequestDTO;
import com.shopping.snack.db.entity.OrdersItem;
import com.shopping.snack.db.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/product/order")
    public String order(OrderRequestDTO orderRequestDTO){
        orderService.orderInsert(orderRequestDTO);

        return "/";
    }
}
