package com.epam.khodyka.db.repository;

import com.epam.khodyka.bean.FilterBean;
import com.epam.khodyka.db.entiry.Guitar;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/6/2015.
 */
public interface ProductRepository {
    Guitar get(int id);

    List<Guitar> getAll();

    List<Guitar> getAllByFilter(FilterBean filterBean);

    int getProductCount(FilterBean filterBean);
}
