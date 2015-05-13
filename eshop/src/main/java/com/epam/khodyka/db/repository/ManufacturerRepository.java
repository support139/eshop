package com.epam.khodyka.db.repository;

import com.epam.khodyka.db.entiry.Manufacturer;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/7/2015.
 */
public interface ManufacturerRepository {
    List<Manufacturer> getAll();
}
