package com.epam.khodyka.service.impl;

import com.epam.khodyka.bean.FilterBean;
import com.epam.khodyka.db.ProductQueryBuilder;
import com.epam.khodyka.db.entiry.Guitar;
import com.epam.khodyka.db.repository.ProductRepository;
import com.epam.khodyka.service.ProductService;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/8/2015.
 */
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = Logger.getLogger(ProductServiceImpl.class);

    private ProductRepository productRepository;
    private ProductQueryBuilder productQueryBuilder;

    public ProductServiceImpl(ProductRepository productRepository, ProductQueryBuilder productQueryBuilder) {
        this.productRepository = productRepository;
        this.productQueryBuilder = productQueryBuilder;
    }

    @Override
    public List<Guitar> getAllProducts() {
        return productRepository.getAll();
    }

    @Override
    public List<Guitar> getProductsByFilter(FilterBean filterBean) {
        return productRepository.getAllByFilter(filterBean);
    }

    @Override
    public int getProductCount(FilterBean filterBean) {
        return productRepository.getProductCount(filterBean);
    }

    @Override
    public Guitar getProductById(int id) {
        return productRepository.get(id);
    }
}
