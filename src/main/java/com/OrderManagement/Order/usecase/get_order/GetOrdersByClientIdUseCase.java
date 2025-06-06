package com.OrderManagement.Order.usecase.get_order;

import com.OrderManagement.Order.controller.dto.OrderDto;
import com.OrderManagement.Order.gateway.IOderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetOrdersByClientIdUseCase implements IGetOrdersByClientIdUseCase {

    private final IOderGateway orderGateway;

    public List<OrderDto> getOrdersByClientId(Long clientId) {
        var orders = orderGateway.findOrdersByClientId(clientId);
        return orders.stream()
                .map(OrderDto::new)
                .toList();
    }
}
