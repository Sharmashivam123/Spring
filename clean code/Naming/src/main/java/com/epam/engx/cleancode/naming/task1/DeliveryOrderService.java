package com.epam.engx.cleancode.naming.task1;

import com.epam.engx.cleancode.naming.task1.thirdpartyjar.*;

import java.util.List;

public class DeliveryOrderService implements OrderService {

    private DeliveryService delivery;

    private OrderFulfilmentService orderService;

    public void submitOrder(Order order) {
        if (delivery.isDeliverable()) {
            List<Product> products = order.getProducts();
            orderService.fulfilProducts(products);
        } else {
            throw new NotDeliverableOrderException();
        }
    }

    public void setDeliveryService(DeliveryService deliveryService) {
        this.delivery = deliveryService;
    }

    public void setOrderFulfilmentService(OrderFulfilmentService orderFulfilmentService) {
        orderService = orderFulfilmentService;
    }
}
