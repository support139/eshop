package com.epam.khodyka.db.repository;

import com.epam.khodyka.db.entiry.Category;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/7/2015.
 */
public interface CategoryRepository {
    List<Category> getAll();
}
