package com.epam.khodyka.db.repository.impl;

import com.epam.khodyka.db.ConnectionHolder;
import com.epam.khodyka.db.DbManager;
import com.epam.khodyka.db.JdbcTemplate;
import com.epam.khodyka.db.entiry.Manufacturer;
import com.epam.khodyka.db.repository.ManufacturerRepository;
import com.epam.khodyka.db.repository.mapper.impl.ManufacturerMapper;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/7/2015.
 */
public class MySqlManufacturerRepository implements ManufacturerRepository {

    private static final String GET_ALL = "Select * from Manufacturer";

    private DbManager dbManager;
    private ConnectionHolder connectionHolder;
    private JdbcTemplate<Manufacturer> jdbcTemplate;

    public MySqlManufacturerRepository(DbManager dbManager, ConnectionHolder connectionHolder) {
        this.dbManager = dbManager;
        this.connectionHolder = connectionHolder;
        this.jdbcTemplate = new JdbcTemplate<>(dbManager, connectionHolder);
    }

    @Override
    public List<Manufacturer> getAll() {
        return jdbcTemplate.getAll(GET_ALL, new ManufacturerMapper());
    }
}
