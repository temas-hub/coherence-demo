package com.company;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofSerializer;
import com.tangosol.io.pof.PofWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

/**
 * User: dkopiychenko
 * Date: 3/28/16.
 */
public class OrderPofSerializer implements PofSerializer<Order>{
    public static final int USER_ID = 1;
    private static Logger logger = LoggerFactory.getLogger(OrderPofSerializer.class);

    public Order deserialize(PofReader in)
            throws IOException
    {
        String id     = in.readString(0);
        String userId = in.readString(USER_ID);

        Order o = new Order(id,userId);
        in.registerIdentity(o);

        o.complete    = in.readBoolean(2);
        o.items       = in.readCollection(3, new ArrayList<LineItem>());


        in.readRemainder();

        logger.debug("de");
        return o;
    }

    public void serialize(PofWriter out, Order o)
            throws IOException
    {
        out.writeString(0, o.id);
        out.writeString(USER_ID, o.userId);
        out.writeBoolean(2, o.complete);
        out.writeCollection(3,o.items,LineItem.class);

        // mark that writing the object is done
        out.writeRemainder(null);
        logger.debug("se");
    }
}
