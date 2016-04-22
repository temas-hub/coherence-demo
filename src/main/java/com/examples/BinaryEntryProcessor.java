package com.examples;

import com.company.OrderPofSerializer;
import com.tangosol.net.BackingMapContext;
import com.tangosol.net.BackingMapManagerContext;
import com.tangosol.util.Binary;
import com.tangosol.util.BinaryEntry;
import com.tangosol.util.InvocableMap;
import com.tangosol.util.ValueExtractor;
import com.tangosol.util.extractor.PofExtractor;
import com.tangosol.util.processor.AbstractProcessor;

/**
 * @author Artem Zhdanov <azhdanov@griddynamics.com>
 * @since 21.04.2016
 *
 * Example processor
 *
 */
public class BinaryEntryProcessor extends AbstractProcessor {

    private String key;

    public Object process(final InvocableMap.Entry entry) {
        //BackingMapManagerContext bmc = ((BinaryEntry)entry).getContext();
        //Binary binaryValue = ((BinaryEntry) bmc.getBackingMapContext("hello-example").getBackingMapEntry(key)).getBinaryValue();

        BinaryEntry binaryEntry = (BinaryEntry) entry;
        ValueExtractor userIdExtractor = new PofExtractor(String.class, OrderPofSerializer.USER_ID);
        String userId = (String)binaryEntry.extractFromValue(userIdExtractor);

        return userId;

    }
}
