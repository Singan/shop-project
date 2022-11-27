package com.shopping.snack.controller;

import com.shopping.snack.DTO.OrderRequestDTO;
import com.shopping.snack.db.entity.OrdersItem;
import com.shopping.snack.db.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/product/order")
    @ResponseBody
    public Object order(@RequestBody OrderRequestDTO orderRequestDTO){
        //orderService.orderInsert(orderRequestDTO);
        System.out.println("실행됨");
        return orderRequestDTO;
    }

}
