package com.epam.khodyka.db.repository.mapper.impl;

import com.epam.khodyka.db.Fields;
import com.epam.khodyka.db.entiry.User;
import com.epam.khodyka.db.repository.mapper.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Andrii_Khodyka on 5/14/2015.
 */
public class UserMapper implements Mapper<User> {

    @Override
    public User extract(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(Fields.USER_ID));
        user.setLogin(resultSet.getString(Fields.USER_LOGIN));
        user.setPassword(resultSet.getString(Fields.USER_PASSWORD));
        user.setName(resultSet.getString(Fields.USER_NAME));
        user.setSurname(resultSet.getString(Fields.USER_SURNAME));
        user.setEmail(resultSet.getString(Fields.USER_EMAIL));
        user.setAvatar(resultSet.getString(Fields.USER_AVATAR));
        return user;
    }
}
