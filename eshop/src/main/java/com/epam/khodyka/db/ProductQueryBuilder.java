package com.epam.khodyka.db;

import com.epam.khodyka.bean.FilterBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/8/2015.
 */
public class ProductQueryBuilder {

    private List<Object> index;
    private StringBuilder sql;

    public Criteria createQuery(FilterBean filterBean, String sql) {
        this.index = new ArrayList<>();
        this.sql = new StringBuilder(sql);
        return queryCretor(filterBean);
    }

    public Criteria createCountQuery(FilterBean filterBean, String sql) {
        index = new ArrayList<>();
        this.sql = new StringBuilder(sql);
        return countQueryCreator(filterBean);
    }

    private Criteria countQueryCreator(FilterBean bean) {
        where();
        boolean whereNeed = false;
        if (bean.getCategories() != null) {
            inCategory(bean.getCategories()).and();
            whereNeed = true;
        }
        if (bean.getManufacturers() != null) {
            inManufacturer(bean.getManufacturers()).and();
            whereNeed = true;
        }
        if (bean.getMin() != null && bean.getMax() != null) {
            priceBetween(bean.getMin(), bean.getMax()).and();
            whereNeed = true;
        }
        if (bean.getName() != null) {
            likeName(bean.getName());
            whereNeed = true;
        } else {
            removeAnd();
        }
        if (!whereNeed) {
            removeWhere();
        }
        return new Criteria(sql.toString(), index);
    }


    private Criteria queryCretor(FilterBean bean) {
        where();
        boolean whereNeed = false;
        if (bean.getCategories() != null) {
            inCategory(bean.getCategories()).and();
            whereNeed = true;
        }
        if (bean.getManufacturers() != null) {
            inManufacturer(bean.getManufacturers()).and();
            whereNeed = true;
        }
        if (bean.getMin() != null && bean.getMax() != null) {
            priceBetween(bean.getMin(), bean.getMax()).and();
            whereNeed = true;
        }
        if (bean.getName() != null) {
            likeName(bean.getName());
            whereNeed = true;
        } else {
            removeAnd();
        }
        if (bean.getOrderBy() != null) {
            orderBy(bean.getOrderBy());
            whereNeed = true;
        }
        if (bean.getLimit() != null) {
            limit(bean.getPage(), bean.getLimit());
            whereNeed = true;
        }
        if (!whereNeed) {
            removeWhere();
        }
        return new Criteria(sql.toString(), index);
    }

    private ProductQueryBuilder orderBy(String orderBy) {
        sql.append(" order by " + orderBy);
        return this;
    }

    private ProductQueryBuilder limit(int page, int limit) {
        sql.append(" limit ?, ?");
        index.add((page - 1) * limit);
        index.add(limit);
        return this;
    }

    private ProductQueryBuilder removeAnd() {
        sql.delete(sql.length() - 4, sql.length());
        return this;
    }

    private ProductQueryBuilder removeWhere() {
        sql.delete(sql.length() - 6, sql.length());
        return this;
    }

    private ProductQueryBuilder and() {
        sql.append(" and ");
        return this;
    }

    private ProductQueryBuilder where() {
        sql.append(" where ");
        return this;
    }

    private ProductQueryBuilder inCategory(List<Integer> categories) {
        sql.append("categoryId in(");
        for (int category : categories) {
            sql.append("?").append(", ");
            index.add(category);
        }
        sql.delete(sql.length() - 2, sql.length()).append(")");
        return this;
    }

    private ProductQueryBuilder inManufacturer(List<Integer> manufacturers) {
        sql.append("manufacturerId in(");
        for (int manufacturer : manufacturers) {
            sql.append("?").append(", ");
            index.add(manufacturer);
        }
        sql.delete(sql.length() - 2, sql.length()).append(")");
        return this;
    }

    private ProductQueryBuilder priceBetween(int from, int to) {
        sql.append("price between ").append("?").append(" and ").append("?");
        index.add(from);
        index.add(to);
        return this;
    }

    private ProductQueryBuilder likeName(String name) {
        sql.append(" name like '%" + name + "%'");
        return this;
    }
}
