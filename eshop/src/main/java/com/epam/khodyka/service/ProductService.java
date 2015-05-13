package com.epam.khodyka.service;

import com.epam.khodyka.bean.FilterBean;
import com.epam.khodyka.db.entiry.Guitar;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/6/2015.
 */
public interface ProductService {
    List<Guitar> getAllProducts();

    List<Guitar> getProductsByFilter(FilterBean filterBean);

    int getProductCount(FilterBean filterBean);

    Guitar getProductById(int id);
}
