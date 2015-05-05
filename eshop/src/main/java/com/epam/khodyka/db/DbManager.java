package com.epam.khodyka.db;

import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Andrii_Khodyka on 5/5/2015.
 */
public class DbManager {

    private static final Logger LOG = Logger.getLogger(DbManager.class);
    private static volatile DbManager manager;

    private DbManager() {
    }

    public static DbManager getInstance() {
        if (manager == null) {
            synchronized (DbManager.class) {
                if (manager == null) {
                    manager = new DbManager();
                }
            }
        }
        return manager;
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = getDataSource().getConnection();
        } catch (SQLException e) {
            LOG.error("Can't get connection", e);
        }
        return con;
    }


    private DataSource getDataSource() {
        DataSource ds = null;
        try {
            InitialContext initContext = new InitialContext();
            ds = (DataSource) initContext.lookup("java:comp/env/jdbc/eshop");
        } catch (NamingException e) {
            LOG.error("Can't get dataSource", e);
        }
        return ds;
    }

    public void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            LOG.error("Can't close connection", e);
        }
    }

    public void closeStatement(Statement stat) {
        try {
            stat.close();
        } catch (SQLException e) {
            LOG.error("Can't close statement", e);
        }
    }

    public void closeResultSet(ResultSet set) {
        try {
            set.close();
        } catch (SQLException e) {
            LOG.error("Can't close result set", e);
        }
    }

}
