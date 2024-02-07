package com.prodramming.orderservice.service;

import com.prodramming.orderservice.dto.OrderLineItemsDto;
import com.prodramming.orderservice.dto.OrderRequest;
import com.prodramming.orderservice.model.Order;
import com.prodramming.orderservice.model.OrderLineItems;
import com.prodramming.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;

    /**
     * Places an order based on the provided order request.
     *
     * @param orderRequest The order request containing order details.
     */
    public void placeOrder(OrderRequest orderRequest){
        // Create a new order instance
        Order order = new Order();

        // Generate a unique order number
        order.setOrderNumber(UUID.randomUUID().toString());

        // Map order line items DTO to entity and set in the order
        List<OrderLineItems> orderLineItems =orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);
        orderRepository.save(order);


    }

    /**
     * Maps an OrderLineItemsDto to OrderLineItems entity.
     *
     * @param orderLineItemsDto The OrderLineItemsDto to map.
     * @return The mapped OrderLineItems entity.
     */
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
       OrderLineItems  orderLineItems = new OrderLineItems();
       orderLineItems.setPrice(orderLineItems.getPrice());
       orderLineItems.setQuantity(orderLineItems.getQuantity());
       orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
       return orderLineItems;
    }
}
