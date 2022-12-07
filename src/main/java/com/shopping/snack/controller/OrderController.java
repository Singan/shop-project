package com.shopping.snack.controller;

import com.shopping.snack.DTO.OrderRequestDTO;
import com.shopping.snack.DTO.OrderViewDTO;
import com.shopping.snack.DTO.SessionMemberDTO;
import com.shopping.snack.db.entity.Orders;
import com.shopping.snack.db.entity.OrdersItem;
import com.shopping.snack.db.service.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final HttpSession httpSession;

    @PostMapping("/product/order")
    @ResponseBody
    public Long order(@RequestBody OrderRequestDTO orderRequestDTO) {

        Long ordersNo;
        SessionMemberDTO member = (SessionMemberDTO) httpSession.getAttribute("user");
        if (member != null) {
            ordersNo = orderService.orderInsert(orderRequestDTO, member.createMember());
        } else {
            ordersNo = orderService.orderInsert(orderRequestDTO);
        }
        return ordersNo;
    }

    @GetMapping("/view/orders")
    public String viewsOrdersGo() {
        return "html/service/nonMember_order";
    }

    @PostMapping("/view/orders")
    @ResponseBody
    public OrderViewDTO viewsOrders(@RequestParam(name = "no") Long no) {

        OrderViewDTO orderViewDTO = new OrderViewDTO(orderService.findOrders(no));
        return orderViewDTO;
    }

}
