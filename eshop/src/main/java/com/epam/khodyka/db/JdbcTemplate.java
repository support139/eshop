package com.epam.khodyka.db;

import com.epam.khodyka.db.exception.SQLRuntimeException;
import com.epam.khodyka.db.repository.mapper.Mapper;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/14/2015.
 */
public class JdbcTemplate<E> {

    private static final Logger LOG = Logger.getLogger(JdbcTemplate.class);

    private DbManager dbManager;
    private ConnectionHolder connectionHolder;

    public JdbcTemplate(DbManager dbManager, ConnectionHolder connectionHolder) {
        this.dbManager = dbManager;
        this.connectionHolder = connectionHolder;
    }

    public List<E> getAll(String sql, Mapper<E> mapper) {
        Connection connection = connectionHolder.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<E> data = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                E object = mapper.extract(resultSet);
                data.add(object);
            }
        } catch (SQLException e) {
            LOG.error("Cannot obtain objects!", e);
            SQLRuntimeException sqlRuntimeException = new SQLRuntimeException();
            sqlRuntimeException.initCause(e);
            throw sqlRuntimeException;
        } finally {
            dbManager.closeResultSet(resultSet);
            dbManager.closeStatement(statement);
        }
        return data;
    }

    public List<E> getAllByCriteria(Criteria criteria, Mapper<E> mapper) {
        Connection connection = connectionHolder.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<E> data = new ArrayList<>();
        try {
            statement = connection.prepareStatement(criteria.getSql());
            for (int i = 0; i < criteria.getParams().size(); i++) {
                statement.setObject(i + 1, criteria.getParams().get(i));
            }
            LOG.info("Completed sql query *** " + statement);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                E object = mapper.extract(resultSet);
                data.add(object);
            }
        } catch (SQLException e) {
            LOG.error("Cannot obtain objects by criteria!", e);
            SQLRuntimeException sqlRuntimeException = new SQLRuntimeException();
            sqlRuntimeException.initCause(e);
            throw sqlRuntimeException;
        } finally {
            dbManager.closeResultSet(resultSet);
            dbManager.closeStatement(statement);
        }
        return data;
    }

    public E get(String sql, Mapper<E> mapper, int id) {
        Connection connection = connectionHolder.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        E object = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                object = mapper.extract(resultSet);
            }
        } catch (SQLException e) {
            LOG.error("Cannot obtain object!", e);
            SQLRuntimeException sqlRuntimeException = new SQLRuntimeException();
            sqlRuntimeException.initCause(e);
            throw sqlRuntimeException;
        } finally {
            dbManager.closeResultSet(resultSet);
            dbManager.closeStatement(statement);
        }
        return object;
    }

    public E get(String sql, Mapper<E> mapper, String login) {
        Connection connection = connectionHolder.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        E object = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                object = mapper.extract(resultSet);
            }
        } catch (SQLException e) {
            LOG.error("Cannot obtain object!", e);
            SQLRuntimeException sqlRuntimeException = new SQLRuntimeException();
            sqlRuntimeException.initCause(e);
            throw sqlRuntimeException;
        } finally {
            dbManager.closeResultSet(resultSet);
            dbManager.closeStatement(statement);
        }
        return object;
    }

    public int add(String sql, Object[] args) {
        Connection connection = connectionHolder.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int generatedId = 0;
        try {
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                generatedId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            LOG.error("Cannot add new object!", e);
            SQLRuntimeException sqlRuntimeException = new SQLRuntimeException();
            sqlRuntimeException.initCause(e);
            throw sqlRuntimeException;
        } finally {
            dbManager.closeResultSet(resultSet);
            dbManager.closeStatement(statement);
        }
        return generatedId;
    }

    public int getProductCountByCriteria(Criteria criteria) {
        Connection connection = connectionHolder.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int total = -1;
        try {
            statement = connection.prepareStatement(criteria.getSql());
            for (int i = 0; i < criteria.getParams().size(); i++) {
                statement.setObject(i + 1, criteria.getParams().get(i));
            }
            LOG.info("Completed count sql query *** " + statement);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(Fields.PRODUCT_TOTAL_COUNT);
            }
        } catch (SQLException e) {
            LOG.error("Cannot obtain total count!", e);
            SQLRuntimeException sqlRuntimeException = new SQLRuntimeException();
            sqlRuntimeException.initCause(e);
            throw sqlRuntimeException;
        } finally {
            dbManager.closeResultSet(resultSet);
            dbManager.closeStatement(statement);
        }
        return total;
    }

}



