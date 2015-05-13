package com.epam.khodyka.bean;

import com.epam.khodyka.db.entiry.Guitar;

/**
 * Created by Andrii_Khodyka on 5/15/2015.
 */
public class OrderItem {

    private Guitar guitar;
    private int amount;
    private double price;

    public OrderItem(Guitar guitar, int amount, double price) {
        this.guitar = guitar;
        this.amount = amount;
        this.price = price;
    }
}
