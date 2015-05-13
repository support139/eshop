package com.epam.khodyka.db.repository.impl;

import com.epam.khodyka.bean.FilterBean;
import com.epam.khodyka.db.*;
import com.epam.khodyka.db.entiry.Guitar;
import com.epam.khodyka.db.repository.ProductRepository;
import com.epam.khodyka.db.repository.mapper.impl.GuitarMapper;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/7/2015.
 */
public class MySqlProductRepository implements ProductRepository {

    private static final String GET_ALL = "Select guitar.id, guitar.name, guitar.price, guitar.body, guitar.scale," +
            " guitar.neck, guitar.fingerboard, guitar.picture, manufacturer.manufacturer, category.category from guitar" +
            " join manufacturer on guitar.manufacturerId = manufacturer.id join category" +
            " on guitar.categoryId = category.id";

    private static final String GET_BY_ID = "Select guitar.id, guitar.name, guitar.price, guitar.body, guitar.scale," +
            " guitar.neck, guitar.fingerboard, guitar.picture, manufacturer.manufacturer, category.category from guitar" +
            " join manufacturer on guitar.manufacturerId = manufacturer.id join category" +
            " on guitar.categoryId = category.id where guitar.id = ?";

    private static final String GET_COUNT = "select count(id) as total from guitar";

    private DbManager dbManager;
    private ConnectionHolder connectionHolder;
    private JdbcTemplate<Guitar> jdbcTemplate;

    public MySqlProductRepository(DbManager dbManager, ConnectionHolder connectionHolder) {
        this.dbManager = dbManager;
        this.connectionHolder = connectionHolder;
        this.jdbcTemplate = new JdbcTemplate<>(dbManager, connectionHolder);
    }

    @Override
    public List<Guitar> getAll() {
        return jdbcTemplate.getAll(GET_ALL, new GuitarMapper());
    }

    @Override
    public List<Guitar> getAllByFilter(FilterBean filterBean) {
        Criteria criteria = new ProductQueryBuilder().createQuery(filterBean, GET_ALL);
        return jdbcTemplate.getAllByCriteria(criteria, new GuitarMapper());
    }

    @Override
    public int getProductCount(FilterBean filterBean) {
        Criteria criteria = new ProductQueryBuilder().createCountQuery(filterBean, GET_COUNT);
        return jdbcTemplate.getProductCountByCriteria(criteria);
    }

    @Override
    public Guitar get(int id) {
        return jdbcTemplate.get(GET_BY_ID, new GuitarMapper(), id);
    }
}
