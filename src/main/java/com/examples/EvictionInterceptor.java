package com.examples;

import com.tangosol.net.events.EventInterceptor;
import com.tangosol.net.events.partition.cache.EntryEvent;

/**
 * @author Artem Zhdanov <azhdanov@griddynamics.com>
 * @since 30.03.2016
 */
public class EvictionInterceptor implements EventInterceptor<EntryEvent<String, String>> {

    private int node;

    public EvictionInterceptor(final int node) {
        this.node = node;
    }

    public void onEvent(final EntryEvent<String, String> stringStringEntryEvent) {
        System.out.println("ID = " + node + " Event happened" + stringStringEntryEvent);
        System.out.println("Value is " + stringStringEntryEvent.getEntrySet().iterator().next().getValue());
    }
}
