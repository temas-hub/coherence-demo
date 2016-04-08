package com.examples;

import com.tangosol.util.MapTrigger;

/**
 * @author Artem Zhdanov <azhdanov@griddynamics.com>
 * @since 05.04.2016
 */
public class PersonMapTrigger implements MapTrigger
{
    public PersonMapTrigger()
    {
    }

    public void process(MapTrigger.Entry entry)
    {

            System.out.println("Entry  [" + entry + "] ");
    }

    // ---- hashCode() and equals() must be implemented

    public boolean equals(Object o)
    {
        return o != null && o.getClass() == this.getClass();
    }
    public int hashCode()
    {
        return getClass().getName().hashCode();
    }
}
