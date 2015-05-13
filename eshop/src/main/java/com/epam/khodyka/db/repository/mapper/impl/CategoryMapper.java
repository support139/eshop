package com.epam.khodyka.db.repository.mapper.impl;

import com.epam.khodyka.db.Fields;
import com.epam.khodyka.db.entiry.Category;
import com.epam.khodyka.db.repository.mapper.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Andrii_Khodyka on 5/14/2015.
 */
public class CategoryMapper implements Mapper<Category> {

    @Override
    public Category extract(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getInt(Fields.CATEGORY_ID));
        category.setCategory(resultSet.getString(Fields.CATEGORY_NAME));
        return category;
    }
}
