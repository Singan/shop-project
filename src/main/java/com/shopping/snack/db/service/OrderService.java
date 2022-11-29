package com.shopping.snack.db.service;

import com.shopping.snack.DTO.OrderRequestDTO;
import com.shopping.snack.db.entity.Member;
import com.shopping.snack.db.entity.Orders;
import com.shopping.snack.db.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;


    public Long orderInsert(OrderRequestDTO orderRequestDTO){
        return orderRepository.orderInsert(orderRequestDTO.getOrders());
    }
    public Long orderInsert(OrderRequestDTO orderRequestDTO,Member member){
        return orderRepository.orderInsert(orderRequestDTO.getOrders(member));
    }
    public List<Orders> ordersList(Member member){

        return orderRepository.ordersList(member);
    }

    public Orders findOrders(Long no){

        return orderRepository.findOrders(no);
    }
}
