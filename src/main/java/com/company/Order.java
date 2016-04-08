package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: dkopiychenko
 * Date: 3/28/16.
 */
public class Order{
    String id;
    List<LineItem> items;
    Boolean complete;
    String userId;

//    public Order() {
//
//    }

    public Order(String id, String userId) {
        this.id = id;
        this.userId = userId;
        this.items = new ArrayList<LineItem>();
        this.complete = false;
    }

    public String getId() {
        return id;
    }

    public void addItem(LineItem item){
        items.add(item);
    }

    public void setComplete(Boolean b) {
        this.complete = b;
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        System.out.println("readObject");
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", items=" + items +
                ", complete=" + complete +
                ", userId='" + userId + '\'' +
                '}';
    }
}
