package com.project.market_app.service.impl;

import com.project.market_app.dto.*;
import com.project.market_app.model.Brand;
import com.project.market_app.model.Order;
import com.project.market_app.model.Product;
import com.project.market_app.model.User;
import com.project.market_app.repository.OrderRepository;
import com.project.market_app.service.inter.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

        // burada info ve add-de etdiyimiz kimi user-i map etmeliyik - BUNA BAX
        List<OrderInfoDto> ordersDto = orders.stream()
                .map(order -> modelMapper.map(order, OrderInfoDto.class)).collect(Collectors.toList());

        return ordersDto;
    }

    @Override
    public OrderInfoDto orderInfo(Long id) {
        Order order = orderRepository.orderInfo(id);
        OrderInfoDto orderInfoDto = modelMapper.map(order, OrderInfoDto.class);

        // order objectin icinde olan user-i orderinfodto-da olan user-e map edirik
        orderInfoDto.setUserInfo(modelMapper.map(order.getUser(), UserInfoDto.class));
        return orderInfoDto;
    }

    @Override
    public void addOrder(AddOrderDto addOrderDto) {
        Order order = modelMapper.map(addOrderDto, Order.class);

        // order objectin icinde olan user-i orderinfodto-da olan user-e map edirik
        order.setUser(modelMapper.map(addOrderDto.getUserInfo(), User.class));
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(UpdateOrderDto updateOrderDto) {
        Order oldOrder = orderRepository.findById(updateOrderDto.getId()).get();

        oldOrder.setOrderDate(updateOrderDto.getOrderDate());
        oldOrder.setTotalPrice(updateOrderDto.getTotalPrice());
        oldOrder.setTotalDiscount(updateOrderDto.getTotalDiscount());
        oldOrder.setPrice(updateOrderDto.getPrice());
        // order objectin icinde olan user-i orderinfodto-da olan user-e map edirik
        oldOrder.setUser(modelMapper.map(updateOrderDto.getUserInfo(), User.class));

        orderRepository.save(oldOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
