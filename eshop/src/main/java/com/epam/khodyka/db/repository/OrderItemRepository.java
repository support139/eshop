package com.epam.khodyka.db.repository;

import com.epam.khodyka.db.entiry.OrderItemEntity;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/21/2015.
 */
public interface OrderItemRepository {
    void addOrderItem(List<OrderItemEntity> itemList);
}
