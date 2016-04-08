package com.examples;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.DefaultCacheServer;
import com.tangosol.net.NamedCache;
import com.tangosol.util.MapTrigger;
import com.tangosol.util.MapTriggerListener;

import static com.examples.RealTimeClient.CACHE_NAME;

/**
 * @author Artem Zhdanov <azhdanov@griddynamics.com>
 * @since 30.03.2016
 */
public class CacheServer {

    public static MapTriggerListener createTriggerListener(String sCacheName)
    {
        MapTrigger trigger;
        if (CACHE_NAME.equals(sCacheName))
        {
            trigger = new PersonMapTrigger();
        }
        else
        {
            throw new IllegalArgumentException("Unknown cache name " + sCacheName);
        }

        System.out.println("Creating MapTrigger for cache " + sCacheName);

        return new MapTriggerListener(trigger);
    }
    public static void main(String[] args) {

//        ConfigurableCacheFactory ccf = CacheFactory.getConfigurableCacheFactory();
//        InterceptorRegistry reg = ccf.getInterceptorRegistry();
//
//        NamedCache cache = CacheFactory.getCache(CACHE_NAME);
//        final PartitionedService cacheService = (PartitionedService) cache.getCacheService();
//        final int id = cacheService.getCluster().getLocalMember().getId();
//
//        reg.registerEventInterceptor(new EvictionInterceptor(id));

//        NamedCache cache = CacheFactory.getCache(CACHE_NAME);
//        cache.addMapListener(createTriggerListener(CACHE_NAME));

        new DefaultCacheServer(CacheFactory.getConfigurableCacheFactory()).startAndMonitor(20000);

    }
}
