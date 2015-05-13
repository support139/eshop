package com.epam.khodyka.db;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/12/2015.
 */
public class Criteria {

    private String sql;
    private List<Object> params;

    public Criteria(String sql, List<Object> params) {
        this.sql = sql;
        this.params = params;
    }

    public String getSql() {
        return sql;
    }

    public List<Object> getParams() {
        return params;
    }
}
