package com.epam.khodyka.db.repository.impl;

import com.epam.khodyka.bean.ShopperBean;
import com.epam.khodyka.db.ConnectionHolder;
import com.epam.khodyka.db.DbManager;
import com.epam.khodyka.db.JdbcTemplate;
import com.epam.khodyka.db.repository.ShopperRepository;

/**
 * Created by Andrii_Khodyka on 5/21/2015.
 */
public class MySqlShopperRepository implements ShopperRepository {

    private static final String ADD_SHOPPER = "Insert into Shopper values(default, ?,?,?,?,?,?,?,?)";

    private DbManager dbManager;
    private ConnectionHolder connectionHolder;
    private JdbcTemplate<ShopperRepository> jdbcTemplate;

    public MySqlShopperRepository(DbManager dbManager, ConnectionHolder connectionHolder) {
        this.dbManager = dbManager;
        this.connectionHolder = connectionHolder;
        this.jdbcTemplate = new JdbcTemplate<>(dbManager, connectionHolder);
    }

    @Override
    public int add(ShopperBean shopperBean) {
        return jdbcTemplate.add(ADD_SHOPPER, new Object[]{shopperBean.getFirstName(), shopperBean.getLastName(),
                shopperBean.getMobilePhone(), shopperBean.getCountry(), shopperBean.getState(), shopperBean.getAdress(),
                shopperBean.getZipCode(), shopperBean.getPayment()});
    }
}
