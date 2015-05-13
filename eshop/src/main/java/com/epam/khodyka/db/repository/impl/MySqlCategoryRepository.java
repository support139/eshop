package com.epam.khodyka.db.repository.impl;

import com.epam.khodyka.db.ConnectionHolder;
import com.epam.khodyka.db.DbManager;
import com.epam.khodyka.db.JdbcTemplate;
import com.epam.khodyka.db.entiry.Category;
import com.epam.khodyka.db.repository.CategoryRepository;
import com.epam.khodyka.db.repository.mapper.impl.CategoryMapper;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/7/2015.
 */
public class MySqlCategoryRepository implements CategoryRepository {

    private static final String GET_ALL = "Select * from Category";

    private DbManager dbManager;
    private ConnectionHolder connectionHolder;
    private JdbcTemplate<Category> jdbcTemplate;

    public MySqlCategoryRepository(DbManager dbManager, ConnectionHolder connectionHolder) {
        this.dbManager = dbManager;
        this.connectionHolder = connectionHolder;
        this.jdbcTemplate = new JdbcTemplate<>(dbManager, connectionHolder);
    }

    @Override
    public List<Category> getAll() {
        return jdbcTemplate.getAll(GET_ALL, new CategoryMapper());
    }

}

