package com.epam.khodyka.bean;

import com.epam.khodyka.db.entiry.Guitar;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrii_Khodyka on 5/15/2015.
 */
public class Basket {
    private Map<Guitar, Integer> basket = new HashMap<>();

    public void add(Guitar guitar) {
        Integer amountOfCurrentGuitar = basket.get(guitar);
        if (amountOfCurrentGuitar == null) {
            basket.put(guitar, 1);
        } else {
            basket.put(guitar, ++amountOfCurrentGuitar);
        }
    }

    public void remove(Guitar guitar) {
        basket.remove(guitar);
    }

    public Map<Guitar, Integer> getBasket() {
        return basket;
    }

    public int getTotalAmount() {
        int totalAmount = 0;
        for (Map.Entry<Guitar, Integer> entry : basket.entrySet()) {
            totalAmount += entry.getValue();
        }
        return totalAmount;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Map.Entry<Guitar, Integer> entry : basket.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }


}
