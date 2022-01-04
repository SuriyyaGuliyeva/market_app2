package com.project.market_app.controller;

import com.project.market_app.dto.*;
import com.project.market_app.service.inter.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // list of order
    @GetMapping("")
    public List<OrderInfoDto> orderList() {
        List<OrderInfoDto> orders = orderService.orderList();
        return orders;
    }

    // order info
    @GetMapping("/{id}")
    public OrderInfoDto orderInfo(@PathVariable("id") Long id) {
        OrderInfoDto orderInfo = orderService.orderInfo(id);
        return orderInfo;
    }

    // add order
    @PostMapping("/add")
    public void addOrder(@Valid @RequestBody AddOrderDto orderDto) {
        orderService.addOrder(orderDto);
    }

    // update order
    @PutMapping("/update")
    public void updateOrder(@Valid @RequestBody UpdateOrderDto orderDto) {
        orderService.updateOrder(orderDto);
    }

    // delete order
    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }
}
