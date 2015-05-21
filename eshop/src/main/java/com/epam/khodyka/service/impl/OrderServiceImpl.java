package com.epam.khodyka.service.impl;

import com.epam.khodyka.bean.Order;
import com.epam.khodyka.bean.OrderItem;
import com.epam.khodyka.db.entiry.OrderEntity;
import com.epam.khodyka.db.entiry.OrderItemEntity;
import com.epam.khodyka.db.repository.OrderItemRepository;
import com.epam.khodyka.db.repository.OrderRepository;
import com.epam.khodyka.db.repository.ShopperRepository;
import com.epam.khodyka.service.OrderService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/21/2015.
 */
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ShopperRepository shopperRepository;
    private OrderItemRepository orderItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ShopperRepository shopperRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.shopperRepository = shopperRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void addNewOrder(Order order) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(order.getOrderDate());

        int shopperId = shopperRepository.add(order.getShopperBean());

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDate(date);
        orderEntity.setShopperId(shopperId);
        orderEntity.setOrderStatus(order.getStatus());
        orderEntity.setStatusDetail(order.getStatusDetail());

        int orderId = orderRepository.add(orderEntity);

        List<OrderItemEntity> orderItemEntities = new ArrayList<>();

        for (OrderItem orderItem : order.getItemList()) {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setGuitarId(orderItem.getGuitar().getId());
            orderItemEntity.setPrice(orderItem.getPrice());
            orderItemEntity.setQuantity(orderItem.getAmount());
            orderItemEntity.setOrderId(orderId);
            orderItemEntities.add(orderItemEntity);
        }
        orderItemRepository.addOrderItem(orderItemEntities);
    }
}
