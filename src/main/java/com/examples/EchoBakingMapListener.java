package com.examples;

import com.tangosol.util.MapEvent;
import com.tangosol.util.MapListener;

/**
 * @author Artem Zhdanov <azhdanov@griddynamics.com>
 * @since 05.04.2016
 */
public class EchoBakingMapListener implements MapListener<String, String> {

    private final String nodeId;

    public EchoBakingMapListener() {
//        ConfigurableCacheFactory ccf = CacheFactory.getConfigurableCacheFactory();
//        InterceptorRegistry reg = ccf.getInterceptorRegistry();
//
//        NamedCache cache = CacheFactory.getCache(CACHE_NAME);
//        final PartitionedService cacheService = (PartitionedService) cache.getCacheService();
//        final int id = cacheService.getCluster().getLocalMember().getId();

        this.nodeId = Thread.currentThread().getName();
    }

    public void entryInserted(final MapEvent<String, String> mapevent) {
        System.out.println("ID = " + nodeId + " Event happened" + mapevent);
    }

    public void entryUpdated(final MapEvent<String, String> mapevent) {
        System.out.println("ID = " + nodeId + " Event happened" + mapevent);
    }

    public void entryDeleted(final MapEvent<String, String> mapevent) {
        System.out.println("ID = " + nodeId + " Event happened" + mapevent);
    }
}
