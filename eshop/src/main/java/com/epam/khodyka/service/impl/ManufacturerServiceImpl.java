package com.epam.khodyka.service.impl;

import com.epam.khodyka.db.entiry.Manufacturer;
import com.epam.khodyka.db.repository.ManufacturerRepository;
import com.epam.khodyka.service.ManufacturerService;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/12/2015.
 */
public class ManufacturerServiceImpl implements ManufacturerService {

    private ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.getAll();
    }
}
