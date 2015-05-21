package com.epam.khodyka.db.repository.impl;

import com.epam.khodyka.db.ConnectionHolder;
import com.epam.khodyka.db.DbManager;
import com.epam.khodyka.db.JdbcTemplate;
import com.epam.khodyka.db.entiry.User;
import com.epam.khodyka.db.exception.SQLRuntimeException;
import com.epam.khodyka.db.repository.UserRepository;
import com.epam.khodyka.db.repository.mapper.impl.UserMapper;

/**
 * Created by Andrii_Khodyka on 5/5/2015.
 */
public class MySqlUserRepository implements UserRepository {

    private static final String GET_USER_BY_ID = "Select * from Users where id = ?";
    private static final String GET_USER_BY_LOGIN = "Select * from Users where login = ?";
    private static final String ADD_USER = "Insert into Users values(default, ?,?,?,?,?,?)";

    private DbManager dbManager;
    private ConnectionHolder connectionHolder;
    private JdbcTemplate<User> jdbcTemplate;

    public MySqlUserRepository(DbManager dbManager, ConnectionHolder connectionHolder) {
        this.dbManager = dbManager;
        this.connectionHolder = connectionHolder;
        this.jdbcTemplate = new JdbcTemplate<>(dbManager, connectionHolder);
    }

    @Override
    public User get(int id) throws SQLRuntimeException {
        return jdbcTemplate.get(GET_USER_BY_ID, new UserMapper(), id);
    }

    @Override
    public User get(String login) throws SQLRuntimeException {
        return jdbcTemplate.get(GET_USER_BY_LOGIN, new UserMapper(), login);
    }

    @Override
    public int add(User user) throws SQLRuntimeException {
        return jdbcTemplate.add(ADD_USER, new Object[]{user.getName(), user.getSurname(), user.getLogin(),
                user.getPassword(), user.getEmail(), user.getAvatar()});
    }
}
