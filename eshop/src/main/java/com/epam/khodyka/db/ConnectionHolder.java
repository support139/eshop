package com.epam.khodyka.db;

import java.sql.Connection;

/**
 * Created by Andrii_Khodyka on 5/5/2015.
 */
public class ConnectionHolder {

    @SuppressWarnings("unchecked")
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return DbManager.getInstance().getConnection();
        }
    };

    public static Connection getConnection() {
        return connectionHolder.get();
    }

    public static void removeConnection() {
        connectionHolder.remove();
    }

}
