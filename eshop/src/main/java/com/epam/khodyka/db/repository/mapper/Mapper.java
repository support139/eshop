package com.epam.khodyka.db.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Andrii_Khodyka on 5/14/2015.
 */
public interface Mapper<E> {
    E extract(ResultSet resultSet) throws SQLException;
}


