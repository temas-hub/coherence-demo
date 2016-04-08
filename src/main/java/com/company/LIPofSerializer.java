package com.company;

import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofSerializer;
import com.tangosol.io.pof.PofWriter;

import java.io.IOException;

/**
 * User: dkopiychenko
 * Date: 3/28/16.
 */
public class LIPofSerializer  implements PofSerializer<LineItem> {

    public LineItem deserialize(PofReader in)
            throws IOException
    {
        String id     = in.readString(0);
        Order o       = in.readObject(1);

        return new LineItem(id,o);
    }

    public void serialize(PofWriter out, LineItem li)
            throws IOException
    {
        out.writeString(0, li.id);
        out.writeObject(1, li.order);

        // mark that writing the object is done
        out.writeRemainder(null);
    }
}