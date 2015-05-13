package com.epam.khodyka.validator.impl;

import com.epam.khodyka.bean.FilterBean;
import com.epam.khodyka.validator.Validator;
import org.apache.log4j.Logger;

/**
 * Created by Andrii_Khodyka on 5/12/2015.
 */
public class FilterBeanValidator implements Validator<FilterBean> {

    private static final Logger LOG = Logger.getLogger(FilterBeanValidator.class);

    private static final int MIN_PRICE = 0;
    private static final int MAX_PRICE = 100_000;

    private static final int MIN_LIMIT = 3;
    private static final int MAX_LIMIT = 12;

    private static final String ORDER_BY_NAME = "name";
    private static final String ORDER_BY_PRICE = "price";

    public boolean isMinPriceValid(Integer minPrice) {
        if (minPrice == null) {
            LOG.error("Min price are not valid *** NULL");
            return false;
        }
        return minPrice >= MIN_PRICE && minPrice <= MAX_PRICE;
    }


    public boolean isMaxPriceValid(Integer maxPrice) {
        if (maxPrice == null) {
            LOG.error("Max price are not valid *** NULL");
            return false;
        }
        return maxPrice >= MIN_PRICE && maxPrice <= MAX_PRICE;
    }

    public boolean isLimitValid(Integer limit) {
        if (limit == null) {
            return false;
        }
        return limit >= MIN_LIMIT && limit <= MAX_LIMIT;
    }

    public boolean isOrderValid(String orderBy) {
        LOG.info("Order ***" + orderBy);
        if (orderBy == null) {
            LOG.error("Order null");
            return false;
        }
        return orderBy.equalsIgnoreCase(ORDER_BY_NAME) || orderBy.equalsIgnoreCase(ORDER_BY_PRICE);
    }

    @Override
    public boolean isValid(FilterBean object) {
        boolean valid = true;
        if (!isLimitValid(object.getLimit())) {
            object.setLimit(MIN_LIMIT);
            valid = false;
            LOG.error("Limit are not valid!");
        }
        if (!isOrderValid(object.getOrderBy())) {
            object.setOrderBy(ORDER_BY_NAME);
            valid = false;
            LOG.error("Order are not valid!");
        }
        if (!isMinPriceValid(object.getMin())) {
            object.setMin(MIN_PRICE);
            valid = false;
            LOG.error("Min price are not valid!");
        }
        if (!isMaxPriceValid(object.getMax())) {
            object.setMax(MAX_PRICE);
            valid = false;
            LOG.error("Max price are not valid!");
        }
        return valid;
    }
}
