package com.company;

/**
 * User: dkopiychenko
 * Date: 3/28/16.
 */
public class LineItem{
    String id;
    Order order;

    public LineItem() {

    }

    public LineItem(String id, Order order) {
        this.id = id;
        this.order = order;
    }
}
