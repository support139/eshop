package com.epam.khodyka.db.repository;

import com.epam.khodyka.db.entiry.OrderEntity;

/**
 * Created by Andrii_Khodyka on 5/21/2015.
 */
public interface OrderRepository {
    int add(OrderEntity order);
}
