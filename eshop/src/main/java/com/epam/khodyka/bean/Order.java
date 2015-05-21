package com.epam.khodyka.bean;

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
    private ShopperBean shopperBean;
    private List<OrderItem> itemList;

    public Order() {
    }

    public Order(int id, OrderStatus status, String statusDetail, Date orderDate, ShopperBean shopperBean, List<OrderItem> itemList) {
        this.id = id;
        this.status = status;
        this.statusDetail = statusDetail;
        this.orderDate = orderDate;
        this.shopperBean = shopperBean;
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

    public ShopperBean getShopperBean() {
        return shopperBean;
    }

    public void setShopperBean(ShopperBean shopperBean) {
        this.shopperBean = shopperBean;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", statusDetail='" + statusDetail + '\'' +
                ", orderDate=" + orderDate +
                ", shopperBean=" + shopperBean +
                ", itemList=" + itemList +
                '}';
    }
}
