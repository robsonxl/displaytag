package org.displaytag.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * <p>Extends Map providing only a different toString() method wich can be used in printing
 * attributes inside an html tag</p>
 * @author fgiust
 * @version $Revision$ ($Author$)
 */
public class HtmlAttributeMap extends HashMap
{

    /**
     * Attribute value delimiter
     */
    private static final char DELIMITER = '"';

    /**
     * character between name and value
     */
    private static final char EQUALS = '=';

    /**
     * space before any attribute
     */
    private static final char SPACE = ' ';

    /**
     * toString method: returns attributes in the format:
     * attributename="attributevalue" attr2="attrValue2" ...
     * @return String representation of the HtmlAttributeMap
     */
    public String toString()
    {
        // fast exit when no attribute are present
        if (size() == 0)
        {
            return "";
        }

        // buffer extimated in number of attributes * 30
        StringBuffer buffer = new StringBuffer(size() * 30);

        // get the entrySet
        Set entrySet = entrySet();

        Iterator iterator = entrySet.iterator();

        // iterates on attributes
        while (iterator.hasNext())
        {
            Map.Entry entry = (Map.Entry) iterator.next();

            // append a new atribute
            buffer.append(SPACE).append(entry.getKey()).append(EQUALS).append(DELIMITER).append(
                entry.getValue()).append(
                DELIMITER);
        }

        // return
        return buffer.toString();
    }
}
