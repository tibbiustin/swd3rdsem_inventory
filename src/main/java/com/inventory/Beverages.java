package com.inventory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 24/11/17.
 */
public class Beverages {

    private final long id;
    private String name;
    private final long price;
    private final long quantity;



    private static List<Beverages> beveragesList = new ArrayList<>();

    public Beverages(long id, String name, long price, long quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }

    public static List<Beverages> getBeveragesList() {
        return beveragesList;
    }

    public static void setBeveragesList(List<Beverages> beveragesList) {
        Beverages.beveragesList = beveragesList;
    }

    public static Beverages getBeveragesById(long id){
        List<Beverages> list = Beverages.getBeveragesList();

        Beverages theOne = new Beverages(-1, "Dummy", 10,20);

        for (int i = 0; i < list.size(); i++) {
            Beverages b = list.get(i);
            if (b.getId() == id) {
                System.out.println(b);
                theOne = b;
                break;
            }
        }
        return theOne;
    }
}
