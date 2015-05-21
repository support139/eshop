package com.epam.khodyka.db.repository.impl;

import com.epam.khodyka.bean.Order;
import com.epam.khodyka.db.ConnectionHolder;
import com.epam.khodyka.db.DbManager;
import com.epam.khodyka.db.JdbcTemplate;
import com.epam.khodyka.db.entiry.OrderEntity;
import com.epam.khodyka.db.repository.OrderRepository;

/**
 * Created by Andrii_Khodyka on 5/21/2015.
 */
public class MySqlOrderRepository implements OrderRepository {

    private static final String ADD_ORDER = "Insert into `Order` values(default, ?,?,?,?)";

    private DbManager dbManager;
    private ConnectionHolder connectionHolder;
    private JdbcTemplate<Order> jdbcTemplate;

    public MySqlOrderRepository(DbManager dbManager, ConnectionHolder connectionHolder) {
        this.dbManager = dbManager;
        this.connectionHolder = connectionHolder;
        this.jdbcTemplate = new JdbcTemplate<>(dbManager, connectionHolder);
    }

    @Override
    public int add(OrderEntity order) {
        return jdbcTemplate.add(ADD_ORDER, new Object[]{order.getOrderStatus().toString(), order.getStatusDetail(),
                order.getOrderDate(), order.getShopperId()});
    }
}
