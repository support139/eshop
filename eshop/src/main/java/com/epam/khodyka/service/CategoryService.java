package com.epam.khodyka.service;

import com.epam.khodyka.db.entiry.Category;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/12/2015.
 */
public interface CategoryService {
    List<Category> getAllCategories();
}
