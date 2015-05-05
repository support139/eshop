package com.epam.khodyka.db.repository.impl;

import com.epam.khodyka.db.ConnectionHolder;
import com.epam.khodyka.db.DbManager;
import com.epam.khodyka.db.Fields;
import com.epam.khodyka.db.entiry.User;
import com.epam.khodyka.db.exception.SQLRuntimeException;
import com.epam.khodyka.db.repository.UserRepository;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Andrii_Khodyka on 5/5/2015.
 */
public class MySqlUserRepository implements UserRepository {

    private static final Logger LOG = Logger.getLogger(MySqlUserRepository.class);

    private static final String GET_USER_BY_ID = "Select * from Users where id = ?";
    private static final String GET_USER_BY_LOGIN = "Select * from Users where login = ?";
    private static final String ADD_USER = "Insert into Users values(default, ?,?,?,?,?,?)";


    @Override
    public User get(int id) {
        User user = null;
        Connection con = ConnectionHolder.getConnection();
        PreparedStatement stat = null;
        ResultSet set = null;
        try {
            stat = con.prepareStatement(GET_USER_BY_ID);
            stat.setInt(1, id);
            set = stat.executeQuery();
            if (set.next()) {
                user = new User();
                user.setId(set.getInt(Fields.USER_ID));
                user.setLogin(set.getString(Fields.USER_LOGIN));
                user.setPassword(set.getString(Fields.USER_PASSWORD));
                user.setName(set.getString(Fields.USER_NAME));
                user.setSurname(set.getString(Fields.USER_SURNAME));
                user.setEmail(set.getString(Fields.USER_EMAIL));
                user.setAvatar(set.getString(Fields.USER_AVATAR));
            }
        } catch (SQLException e) {
            LOG.error("Can't obtain user by id", e);
            SQLRuntimeException sqlRuntimeException = new SQLRuntimeException();
            sqlRuntimeException.initCause(e);
            throw sqlRuntimeException;
        } finally {
            DbManager.getInstance().closeResultSet(set);
            DbManager.getInstance().closeStatement(stat);
        }
        return user;
    }

    @Override
    public User get(String login) {
        User user = null;
        Connection con = ConnectionHolder.getConnection();
        PreparedStatement stat = null;
        ResultSet set = null;
        try {
            stat = con.prepareStatement(GET_USER_BY_LOGIN);
            stat.setString(1, login);
            set = stat.executeQuery();
            if (set.next()) {
                user = new User();
                user.setId(set.getInt(Fields.USER_ID));
                user.setLogin(set.getString(Fields.USER_LOGIN));
                user.setPassword(set.getString(Fields.USER_PASSWORD));
                user.setName(set.getString(Fields.USER_NAME));
                user.setSurname(set.getString(Fields.USER_SURNAME));
                user.setEmail(set.getString(Fields.USER_EMAIL));
                user.setAvatar(set.getString(Fields.USER_AVATAR));
            }
        } catch (SQLException e) {
            LOG.error("Can't obtain user by login", e);
            SQLRuntimeException sqlRuntimeException = new SQLRuntimeException();
            sqlRuntimeException.initCause(e);
            throw sqlRuntimeException;
        } finally {
            DbManager.getInstance().closeResultSet(set);
            DbManager.getInstance().closeStatement(stat);
        }
        return user;
    }

    @Override
    public void add(User user) {
        Connection con = ConnectionHolder.getConnection();
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(ADD_USER);
            stat.setString(1, user.getLogin());
            stat.setString(2, user.getPassword());
            stat.setString(3, user.getName());
            stat.setString(4, user.getSurname());
            stat.setString(5, user.getEmail());
            stat.setString(6, user.getAvatar());
            stat.executeUpdate();
        } catch (SQLException e) {
            LOG.error("Can't add new user", e);
            SQLRuntimeException sqlRuntimeException = new SQLRuntimeException();
            sqlRuntimeException.initCause(e);
            throw sqlRuntimeException;
        } finally {
            DbManager.getInstance().closeStatement(stat);
        }
    }
}
