package com.project.market_app.service.impl;

import com.project.market_app.dto.AddOrderDto;
import com.project.market_app.dto.OrderInfoDto;
import com.project.market_app.dto.UpdateOrderDto;
import com.project.market_app.model.Order;
import com.project.market_app.repository.OrderRepository;
import com.project.market_app.service.inter.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrderInfoDto> orderList() {
        List<Order> orders = orderRepository.findAll();
        List<OrderInfoDto> ordersDto = orders.stream()
                .map(order -> modelMapper.map(order, OrderInfoDto.class)).collect(Collectors.toList());

        return ordersDto;
    }

    @Override
    public OrderInfoDto orderInfo(Long id) {
        Order order = orderRepository.findById(id).get();
        OrderInfoDto orderInfoDto = modelMapper.map(order, OrderInfoDto.class);

        return orderInfoDto;
    }

    @Override
    public void addOrder(AddOrderDto addOrderDto) {
        Order order = modelMapper.map(addOrderDto, Order.class);
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(UpdateOrderDto updateOrderDto) {
        Order oldOrder = orderRepository.findById(updateOrderDto.getId()).get();

        oldOrder.setOrderDate(updateOrderDto.getOrderDate());
        oldOrder.setTotalPrice(updateOrderDto.getTotalPrice());
        oldOrder.setTotalDiscount(updateOrderDto.getTotalDiscount());
        oldOrder.setPrice(updateOrderDto.getPrice());

        orderRepository.save(oldOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
