package com.epam.khodyka.db.repository.mapper.impl;

import com.epam.khodyka.db.Fields;
import com.epam.khodyka.db.entiry.Manufacturer;
import com.epam.khodyka.db.repository.mapper.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Andrii_Khodyka on 5/14/2015.
 */
public class ManufacturerMapper implements Mapper<Manufacturer> {

    @Override
    public Manufacturer extract(ResultSet resultSet) throws SQLException {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(resultSet.getInt(Fields.MANUFACTURER_ID));
        manufacturer.setManufacturer(resultSet.getString(Fields.MANUFACTURER_NAME));
        return manufacturer;
    }
}
