package com.project.market_app.service.inter;

import com.project.market_app.dto.AddOrderDto;
import com.project.market_app.dto.OrderInfoDto;
import com.project.market_app.dto.UpdateOrderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<OrderInfoDto> orderList();

    OrderInfoDto orderInfo(Long id);

    void addOrder(AddOrderDto addOrderDto);

    void updateOrder(UpdateOrderDto updateOrderDto);

    void deleteOrder(Long id);
}
