package com.prodramming.orderservice.controller;

import com.prodramming.orderservice.dto.OrderRequest;
import com.prodramming.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    /**
     * Endpoint to place a new order.
     *
     * @param orderRequest The request containing order details.
     * @return A message indicating successful order placement.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
}
