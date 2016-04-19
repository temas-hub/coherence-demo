package com.examples;

import com.company.LineItem;
import com.company.Order;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.ConfigurableCacheFactory;
import com.tangosol.net.DefaultCacheServer;
import com.tangosol.net.Invocable;
import com.tangosol.net.InvocationObserver;
import com.tangosol.net.InvocationService;
import com.tangosol.net.Member;
import com.tangosol.net.NamedCache;
import com.tangosol.net.PartitionedService;
import com.tangosol.net.partition.PartitionSet;
import com.tangosol.util.Filter;
import com.tangosol.util.InvocableMap;
import com.tangosol.util.filter.PartitionedFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Map;

public class RealTimeClient {

    public static final String CACHE_NAME = "hello-example";
    public static final String KEY = "ggg5";
    private static final int ORDERS_COUNT = 5;

    private static Logger logger = LoggerFactory.getLogger(RealTimeClient.class);

//    public static class UpdateJob implements Invocable {
//        private transient Object result = null ;
//        private String cacheName ;
//        public UpdateJob (String cacheName) {
//            this.cacheName = cacheName ;
//        }
//        public void init ( InvocationService invocationservice ) {
//        }
//        public void run () {
//            NamedCache cache = CacheFactory.getCache (cacheName);
//            for (int i = 0; i < ORDERS_COUNT; i++) {
//                String key = KEY + i;
//                if (cache.lock(key, 0)) {
//                    try {
//                        Order value = (Order)cache.get(key);
//                        LineItem lNew = new LineItem("u" + i,value);
//                        value.addItem(lNew);
//                        cache.remove(key);
//                        cache.put(key,value);
//                    } finally {
//                        cache.unlock(key);
//                    }
//                }
//            }
//        }
//        public Object getResult () {
//            return result ;
//        }
//    }


    public static void main(String[] args) throws InterruptedException{

        //CacheFactory.ensureCluster();
        NamedCache cache = CacheFactory.getCache(CACHE_NAME);

        long start = System.currentTimeMillis();
        //insert
        for (int i = 0; i < ORDERS_COUNT; i++) {
            Order oNew = new Order(KEY + i,"u1" + i);
            LineItem lNew = new LineItem("l" + i,oNew);
            oNew.addItem(lNew);
            cache.put(oNew.getId(),oNew);
        }
        long insertDelta = System.currentTimeMillis() - start;
        start = System.currentTimeMillis();
        // update
//        for (int i = 0; i < ORDERS_COUNT; i++) {
//            String key = KEY + i;
//            Order value = (Order)cache.get(key);
//            if (value != null) {
//                LineItem lNew = new LineItem("u" + i,value);
//                value.addItem(lNew);
//                cache.remove(key);
//                cache.put(key,value);
//            }
//        }


        // update with lock

//        final InvocationService invocationService = (InvocationService)CacheFactory.getService("ExtendTcpInvocationService");
//
//        logger.info("Update is started");
//        invocationService.execute(new UpdateJob(CACHE_NAME), null, new InvocationObserver() {
//            public void memberCompleted(final Member member, final Object o) {
//                logger.info("Member {} is done ", member);
//            }
//
//            public void memberFailed(final Member member, final Throwable throwable) {
//                logger.info("Member {} is done ", member);
//            }
//
//            public void memberLeft(final Member member) {
//                logger.info("Member {} is done ", member);
//            }
//
//            public void invocationCompleted() {
//                logger.info("Update is complete");
//            }
//        });

//        for (int i = 0; i < ORDERS_COUNT; i++) {
//            String key = KEY + i;
//            if (cache.lock(key, 0)) {
//                try {
//                    Order value = (Order)cache.get(key);
//                    LineItem lNew = new LineItem("u" + i,value);
//                    value.addItem(lNew);
//                    cache.remove(key);
//                    cache.put(key,value);
//                } finally {
//                    cache.unlock(key);
//                }
//            }
//        }

        logger.info("Inserted in {}",  ORDERS_COUNT / insertDelta * 100);
        //logger.info("Updated in {}", ORDERS_COUNT / (System.currentTimeMillis() - start) * 100);


        //logger.debug("Value in cache after update is " + ((Order)cache.get(KEY)).getItems());

//        cache.put(KEY, value);
//        System.out.println((String)cache.get(KEY));

        new DefaultCacheServer(CacheFactory.getConfigurableCacheFactory()).startAndMonitor(20000);


    }
}