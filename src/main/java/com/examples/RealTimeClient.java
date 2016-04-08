package com.examples;

import com.company.LineItem;
import com.company.Order;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.ConfigurableCacheFactory;
import com.tangosol.net.DefaultCacheServer;
import com.tangosol.net.NamedCache;
import com.tangosol.net.PartitionedService;
import com.tangosol.net.events.InterceptorRegistry;
import com.tangosol.util.AbstractMapListener;
import com.tangosol.util.MapEvent;
import com.tangosol.util.RegistrationBehavior;

public class RealTimeClient {

    public static final String CACHE_NAME = "hello-example";
    public static final String KEY = "ggg5";

    public static void main(String[] args) {

        CacheFactory.ensureCluster();
        NamedCache cache = CacheFactory.getCache(CACHE_NAME);
        Order o1 = new Order(KEY,"u1");
        LineItem li1 = new LineItem("li5",o1);
        o1.addItem(li1);
        cache.put(o1.getId(),o1);

        System.out.println("Value in cache is " + cache.get(KEY));

//        cache.put(KEY, value);
//        System.out.println((String)cache.get(KEY));

        new DefaultCacheServer(CacheFactory.getConfigurableCacheFactory()).startAndMonitor(20000);


    }
}