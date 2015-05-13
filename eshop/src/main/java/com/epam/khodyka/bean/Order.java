package com.epam.khodyka.bean;

import com.epam.khodyka.db.entiry.OrderStatus;

import java.util.Date;
import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/15/2015.
 */
public class Order {
    private int id;
    private OrderStatus status;
    private String statusDetail;
    private Date orderDate;
    private OrderUser user;
    private List<OrderItem> itemList;

    public Order() {
    }

    public Order(int id, OrderStatus status, String statusDetail, Date orderDate, OrderUser user, List<OrderItem> itemList) {
        this.id = id;
        this.status = status;
        this.statusDetail = statusDetail;
        this.orderDate = orderDate;
        this.user = user;
        this.itemList = itemList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderUser getUser() {
        return user;
    }

    public void setUser(OrderUser user) {
        this.user = user;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }
}
