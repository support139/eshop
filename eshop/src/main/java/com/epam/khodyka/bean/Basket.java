package com.epam.khodyka.bean;

import com.epam.khodyka.db.entiry.Guitar;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Andrii_Khodyka on 5/15/2015.
 */
public class Basket {
    private Map<Guitar, Integer> basket = new ConcurrentHashMap();

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

    public int getQuantity() {
        int quantity = 0;
        for (Map.Entry<Guitar, Integer> entry : basket.entrySet()) {
            quantity += entry.getValue();
        }
        return quantity;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Map.Entry<Guitar, Integer> entry : basket.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }

    public void clearBasket(){
        basket.clear();
    }

    public void changeItemQuantity(int orderItemId, int newQuantity){
        for (Map.Entry<Guitar, Integer> entry : basket.entrySet()) {
            if (entry.getKey().getId() == orderItemId) {
                basket.put(entry.getKey(), newQuantity);
            }
        }
    }

    public void removeOrderItem(int orderItemId){
        for (Map.Entry<Guitar, Integer> entry : basket.entrySet()) {
            if (entry.getKey().getId() == orderItemId) {
                basket.remove(entry.getKey());
            }
        }
    }




}
