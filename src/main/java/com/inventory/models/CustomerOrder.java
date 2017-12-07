package com.inventory.models;

import javax.persistence.*;

/**
 * Created by stenpaaro on 06/12/2017.
 */
@Entity
@Table(name = "customerOrder")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "productName")
    private String productName;
    @Column(name = "quantity")
    private float quantity;
    @Column(name = "total_price")
    private float totalPrice;
    @Column(name ="customer_name")
    private String customerName;

    public CustomerOrder(){

    }

    public CustomerOrder(String productName, float quantity, float totalPrice, String customerName) {
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.customerName = customerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
