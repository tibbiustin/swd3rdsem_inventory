package com.inventory.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;
/**
 * Created by George Stratulat on 28/11/2017.
 */

@Entity
@Table(name = "beverages")
public class Beverage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "name")
    public String name;
    @Column(name = "quantity")
    public float quantity;
    @Column(name="price_per_unit")
    public float price_per_unit;

    public Beverage(){

    }

    public Beverage(String name, float quantity, float price_per_unit) {
        this.name = name;
        this.quantity = quantity;
        this.price_per_unit = price_per_unit;
    }

    public Beverage(int id, String name, float quantity, float price_per_unit) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price_per_unit = price_per_unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice_per_unit() {
        return price_per_unit;
    }

    public void setPrice_per_unit(float price_per_unit) {
        this.price_per_unit = price_per_unit;
    }
}
