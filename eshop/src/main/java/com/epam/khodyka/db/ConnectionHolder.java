package com.epam.khodyka.db;

import java.sql.Connection;

/**
 * Created by Andrii_Khodyka on 5/5/2015.
 */
public class ConnectionHolder {

    @SuppressWarnings("unchecked")
    private ThreadLocal<Connection> connectionHolder = new ThreadLocal();

    public void setConnection(Connection connection) {
        connectionHolder.set(connection);
    }

    public Connection getConnection() {
        return connectionHolder.get();
    }

    public void removeConnection() {
        connectionHolder.remove();
    }

}
