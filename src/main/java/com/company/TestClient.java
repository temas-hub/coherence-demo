package com.company;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

public class TestClient {

    public static void main(String[] args) {

        NamedCache myCache = CacheFactory.getCache("mycache");

//        ValueExtractor veUser = new PofExtractor(String.class, OrderPofSerializer.USER_ID);
//        myCache.addIndex(veUser, true, null);


        Order o1 = new Order("ggg5","u1");
        LineItem li1 = new LineItem("li5",o1);
        o1.addItem(li1);
        myCache.put(o1.id,o1);

        System.out.println("Value in cache is " + myCache.get("ggg5"));
    }
}
