package com.inventory.models;

import javax.persistence.*;

/**
 * Created by Tibi on 29/11/2017.
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "supplierName")
    private String supplierName;
    @Column(name = "beverageName")
    private String beverageName;
    @Column(name = "quantity")
    public float quantity;
    @Column(name="price")
    private float price;

    public Order() {

    }

    public Order(String supplierName,String beverageName ,float quantity, float price) {
        this.supplierName = supplierName;
        this.beverageName = beverageName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
