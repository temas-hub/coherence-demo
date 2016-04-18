package com.company;

import com.examples.RealTimeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: dkopiychenko
 * Date: 3/28/16.
 */
public class Order{
    private static Logger logger = LoggerFactory.getLogger(Order.class);

    static {
        logger.debug("Order initialized");
    }

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

    public List<LineItem> getItems() {
        return items;
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        logger.debug("readObject");
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
