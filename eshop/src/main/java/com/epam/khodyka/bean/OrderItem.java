package com.epam.khodyka.bean;

import com.epam.khodyka.db.entiry.Guitar;

/**
 * Created by Andrii_Khodyka on 5/15/2015.
 */
public class OrderItem {

    private Guitar guitar;
    private int amount;
    private double price;

    public OrderItem() {

    }

    public OrderItem(Guitar guitar, int amount, double price) {
        this.guitar = guitar;
        this.amount = amount;
        this.price = price;
    }

    public Guitar getGuitar() {
        return guitar;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "OrderItem{" +
                "guitar=" + guitar +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
