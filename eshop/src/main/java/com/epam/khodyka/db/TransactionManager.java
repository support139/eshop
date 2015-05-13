package com.epam.khodyka.db;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * Created by Andrii_Khodyka on 5/5/2015.
 */
public class TransactionManager<T> implements InvocationHandler {

    private T service;
    private DbManager dbManager;
    private ConnectionHolder connectionHolder;

    public TransactionManager(T service, DbManager dbManager, ConnectionHolder connectionHolder) {
        this.service = service;
        this.dbManager = dbManager;
        this.connectionHolder = connectionHolder;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Connection con = dbManager.getConnection();
        connectionHolder.setConnection(con);
        Object result = null;
        try {
            result = method.invoke(service, args);
            con.commit();
        } catch (Exception e) {
            con.rollback();
        } finally {
            con.close();
            connectionHolder.removeConnection();
        }
        return result;
    }
}
