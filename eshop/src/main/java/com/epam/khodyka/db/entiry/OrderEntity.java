package com.epam.khodyka.db.entiry;

import com.epam.khodyka.bean.OrderStatus;

/**
 * Created by Andrii_Khodyka on 5/22/2015.
 */
public class OrderEntity {
    private int id;
    private OrderStatus orderStatus;
    private String statusDetail;
    private String orderDate;
    private int shopperId;

    public OrderEntity(int id, OrderStatus orderStatus, String statusDetail, String orderDate, int shopperId) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.statusDetail = statusDetail;
        this.orderDate = orderDate;
        this.shopperId = shopperId;
    }

    public OrderEntity(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getShopperId() {
        return shopperId;
    }

    public void setShopperId(int shopperId) {
        this.shopperId = shopperId;
    }

}
