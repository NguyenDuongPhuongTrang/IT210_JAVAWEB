package btvn.ss02.gioi3.model;

import java.util.Date;

public class Order {
    private String orderId;
    private String productName;
    private double total;
    private Date orderDate;

    public Order(String orderId, String productName, double total, Date orderDate) {
        this.orderId = orderId;
        this.productName = productName;
        this.total = total;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}