package com.examples;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

/**
 * @author Artem Zhdanov <azhdanov@griddynamics.com>
 * @since 25.03.2016
 */
public class ReadCache {
    public static void main(String[] args) {
        //CacheFactory.ensureCluster();

        final NamedCache<Object, Object> cache = CacheFactory.getCache(RealTimeClient.CACHE_NAME);
        final Object result = cache.get(RealTimeClient.KEY);
        System.out.println(result);
    }
}
