package com.epam.khodyka.util;

import com.epam.khodyka.bean.FilterBean;

/**
 * Created by Andrii_Khodyka on 5/13/2015.
 */
public class UrlBuilder {

    public static String generate(FilterBean filterBean) {
        StringBuilder URL = new StringBuilder();
        URL.append("Product?");
        if (filterBean.getCategories() != null) {
            for (int category : filterBean.getCategories()) {
                URL.append("category=" + category).append("&");
            }
        }
        if (filterBean.getManufacturers() != null) {
            for (int manufacturer : filterBean.getManufacturers()) {
                URL.append("manufacturer=" + manufacturer).append("&");
            }
        }
        if (filterBean.getMin() != null) {
            URL.append("minPrice=" + filterBean.getMin()).append("&");
        }
        if (filterBean.getMax() != null) {
            URL.append("maxPrice=" + filterBean.getMax()).append("&");
        }
        if (filterBean.getLimit() != null) {
            URL.append("limit=" + filterBean.getLimit()).append("&");
        }
        if (filterBean.getOrderBy() != null) {
            URL.append("orderBy=" + filterBean.getOrderBy()).append("&");
        }
        if(filterBean.getName() != null){
            URL.append("name=" + filterBean.getName());
        }
        return URL.toString();
    }
}
