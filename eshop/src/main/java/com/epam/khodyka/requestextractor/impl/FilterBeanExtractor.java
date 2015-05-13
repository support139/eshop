package com.epam.khodyka.requestextractor.impl;

import com.epam.khodyka.bean.FilterBean;
import com.epam.khodyka.requestextractor.Extractor;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/8/2015.
 */
public class FilterBeanExtractor implements Extractor<FilterBean> {

    @Override
    public FilterBean extract(HttpServletRequest req) {

        FilterBean filterBean = new FilterBean();

        String[] categories = req.getParameterValues("category");
        String[] manufacturers = req.getParameterValues("manufacturer");
        int min = checkInteger(req.getParameter("minPrice"));
        int max = checkInteger(req.getParameter("maxPrice"));
        String orderBy = req.getParameter("orderBy");
        int limit = checkInteger(req.getParameter("limit"));
        int page = checkInteger(req.getParameter("page"));
        String name = req.getParameter("name");

        if (categories != null) {
            List<Integer> categoryList = new ArrayList<>();
            for (String category : categories) {
                categoryList.add(Integer.parseInt(category));
            }
            filterBean.setCategories(categoryList);
        }
        if (manufacturers != null) {
            List<Integer> manufacturerList = new ArrayList<>();
            for (String manufacturer : manufacturers) {
                manufacturerList.add(Integer.parseInt(manufacturer));
            }
            filterBean.setManufacturers(manufacturerList);
        }
        if (orderBy != null && orderBy.length() != 0) {
            filterBean.setOrderBy(orderBy);
        }
        if (name != null && name.length() != 0) {
            filterBean.setName(name);
        }
        if (min != -1) {
            filterBean.setMin(min);
        }
        if (max != -1) {
            filterBean.setMax(max);
        }
        if (limit != -1) {
            filterBean.setLimit(limit);
        }
        if (page != -1) {
            filterBean.setPage(page);
        } else {
            filterBean.setPage(1);
        }

        return filterBean;
    }

    private int checkInteger(String value) {
        if (value != null && value.length() != 0) {
            return Integer.parseInt(value);
        }
        return -1;
    }
}
