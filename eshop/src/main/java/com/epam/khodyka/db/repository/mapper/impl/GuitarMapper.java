package com.epam.khodyka.db.repository.mapper.impl;

import com.epam.khodyka.db.Fields;
import com.epam.khodyka.db.entiry.Category;
import com.epam.khodyka.db.entiry.Guitar;
import com.epam.khodyka.db.entiry.Manufacturer;
import com.epam.khodyka.db.repository.mapper.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Andrii_Khodyka on 5/14/2015.
 */
public class GuitarMapper implements Mapper<Guitar> {

    private Mapper<Manufacturer> manufacturerMapper;
    private Mapper<Category> categoryMapper;

    public GuitarMapper() {
        this.manufacturerMapper = new ManufacturerMapper();
        this.categoryMapper = new CategoryMapper();
    }

    @Override
    public Guitar extract(ResultSet resultSet) throws SQLException {
        Guitar guitar = new Guitar();
        guitar.setId(resultSet.getInt(Fields.PRODUCT_GUITAR_ID));
        guitar.setName(resultSet.getString(Fields.PRODUCT_GUITAR_NAME));
        guitar.setPrice(resultSet.getDouble(Fields.PRODUCT_GUITAR_PRICE));
        guitar.setBody(resultSet.getString(Fields.PRODUCT_GUITAR_BODY));
        guitar.setScale(resultSet.getDouble(Fields.PRODUCT_GUITAR_SCALE));
        guitar.setNeck(resultSet.getString(Fields.PRODUCT_GUITAR_NECK));
        guitar.setFingerboard(resultSet.getString(Fields.PRODUCT_GUITAR_FINGERBOARD));
        guitar.setPicture(resultSet.getString(Fields.PRODUCT_GUITAR_PICTURE));

        Manufacturer manufacturer = manufacturerMapper.extract(resultSet);
        guitar.setManufacturer(manufacturer);

        Category category = categoryMapper.extract(resultSet);
        guitar.setCategory(category);

        return guitar;
    }
}
