package com.examples;

import com.company.LineItem;
import com.company.Order;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.ConfigurableCacheFactory;
import com.tangosol.net.DefaultCacheServer;
import com.tangosol.net.NamedCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RealTimeClient {

    public static final String CACHE_NAME = "hello-example";
    public static final String KEY = "ggg5";

    private static Logger logger = LoggerFactory.getLogger(RealTimeClient.class);


    public static void main(String[] args) throws InterruptedException{

        CacheFactory.ensureCluster();
        NamedCache cache = CacheFactory.getCache(CACHE_NAME);
//        Order o1 = new Order(KEY,"u1");
//        Order o1_2 = new Order(KEY,"u1");
//        LineItem li1 = new LineItem("li5",o1);
//        o1.addItem(li1);
//        cache.put(o1.getId(),o1);

        //logger.debug("Value in cache is " + ((Order)cache.get(KEY)).getItems());

//        Thread.sleep(3000);
        //cache.remove(o1.getId());

//        LineItem li2 = new LineItem("l2",o1_2);
//        o1_2.addItem(li2);
//        cache.put(o1.getId(),o1_2);

        for (int i = 0; i < 40; i++) {
            Order oNew = new Order(KEY + i,"u1" + i);
            LineItem lNew = new LineItem("l" + i,oNew);
            oNew.addItem(lNew);
            cache.put(oNew.getId(),oNew);
            Thread.sleep(500);
        }

        //logger.debug("Value in cache after update is " + ((Order)cache.get(KEY)).getItems());

//        cache.put(KEY, value);
//        System.out.println((String)cache.get(KEY));

        new DefaultCacheServer(CacheFactory.getConfigurableCacheFactory()).startAndMonitor(20000);


    }
}