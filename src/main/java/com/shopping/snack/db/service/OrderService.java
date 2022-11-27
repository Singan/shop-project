package com.shopping.snack.db.service;

import com.shopping.snack.DTO.OrderRequestDTO;
import com.shopping.snack.db.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;


    public Long orderInsert(OrderRequestDTO orderRequestDTO){
        return orderRepository.orderInsert(orderRequestDTO.getOrders());
    }

}
