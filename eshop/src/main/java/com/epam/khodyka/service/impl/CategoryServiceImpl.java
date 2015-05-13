package com.epam.khodyka.service.impl;

import com.epam.khodyka.db.entiry.Category;
import com.epam.khodyka.db.repository.CategoryRepository;
import com.epam.khodyka.service.CategoryService;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/12/2015.
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAll();
    }
}
