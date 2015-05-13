package com.epam.khodyka.bean;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/12/2015.
 */
public class FilterBean {
    private List<Integer> categories;
    private List<Integer> manufacturers;
    private Integer min;
    private Integer max;
    private String orderBy;
    private Integer limit;
    private Integer page;
    private String name;

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public List<Integer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(List<Integer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
