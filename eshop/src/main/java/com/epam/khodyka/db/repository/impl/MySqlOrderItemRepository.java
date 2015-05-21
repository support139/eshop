package com.epam.khodyka.db.repository.impl;

import com.epam.khodyka.bean.OrderItem;
import com.epam.khodyka.db.ConnectionHolder;
import com.epam.khodyka.db.DbManager;
import com.epam.khodyka.db.JdbcTemplate;
import com.epam.khodyka.db.entiry.OrderItemEntity;
import com.epam.khodyka.db.repository.OrderItemRepository;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/21/2015.
 */
public class MySqlOrderItemRepository implements OrderItemRepository {

    private static final String ADD_ORDER_ITEM = "Insert into OrderItem values (default, ?,?,?, ?)";

    private DbManager dbManager;
    private ConnectionHolder connectionHolder;
    private JdbcTemplate<OrderItem> jdbcTemplate;

    public MySqlOrderItemRepository(DbManager dbManager, ConnectionHolder connectionHolder) {
        this.dbManager = dbManager;
        this.connectionHolder = connectionHolder;
        this.jdbcTemplate = new JdbcTemplate<>(dbManager, connectionHolder);
    }

    @Override
    public void addOrderItem(List<OrderItemEntity> itemList) {
        for (OrderItemEntity orderItem : itemList) {
            jdbcTemplate.add(ADD_ORDER_ITEM, new Object[]{orderItem.getQuantity(), orderItem.getPrice(),
                    orderItem.getGuitarId(), orderItem.getOrderId()});
        }
    }


}
