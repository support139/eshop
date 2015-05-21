package com.epam.khodyka.db.entiry;

/**
 * Created by Andrii_Khodyka on 5/22/2015.
 */
public class OrderItemEntity {

    private int id;
    private int guitarId;
    private int quantity;
    private double price;
    private int orderId;

    public OrderItemEntity(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuitarId() {
        return guitarId;
    }

    public void setGuitarId(int guitarId) {
        this.guitarId = guitarId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
