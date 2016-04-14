package com.examples;

import com.company.Order;
import com.tangosol.net.cache.MapCacheStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Artem Zhdanov <azhdanov@griddynamics.com>
 * @since 08.04.2016
 */
public class MapLoggingStore extends MapCacheStore {
    
    private static Logger logger = LoggerFactory.getLogger(MapLoggingStore.class);
    
    public MapLoggingStore() {
        super(new HashMap());
    }

    @Override
    public Object load(final Object key) {
        logger.debug("Load starts for a key " + key);
        final Object result = super.load(key);
        logger.debug("Load is done for a key " + key);
        return result;
    }

    @Override
    public void store(final Object key, final Object value) {
        logger.debug("Store starts for key " + key + " and value "+ value);
        super.store(key, value);
        logger.debug("Store ends for key " + key + " and value "+ value);
    }

    @Override
    public void storeAll(final Map mapEntries) {
        logger.debug("Bulk store starts for map " + mapEntries);
        super.storeAll(mapEntries);
        logger.debug("Bulk store ends for map " + mapEntries);
    }

    @Override
    public void erase(final Object key) {
        logger.debug("Erease starts for key " + key) ;
        super.erase(key);
        logger.debug("Erease ends for key " + key) ;
    }

    @Override
    public void eraseAll(final Collection colKeys) {
        logger.debug("Erease starts for collection" + colKeys) ;
        super.eraseAll(colKeys);
        logger.debug("Erease ends for collection" + colKeys) ;
    }
}
