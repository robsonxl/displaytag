package org.displaytag.jsptests;

import org.displaytag.properties.MediaTypeEnum;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.test.DisplaytagCase;
import org.displaytag.util.ParamEncoder;
import org.junit.Assert;
import org.junit.Test;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;


/**
 * Test for #968559.
 * @author Fabrizio Giustina
 * @version $Revision$ ($Author$)
 */
public class ExportUTF8Test extends DisplaytagCase
{

    /**
     * @see org.displaytag.test.DisplaytagCase#getJspName()
     */
    public String getJspName()
    {
        return "utf8.jsp";
    }

    /**
     * Test response encoding.
     * @param jspName jsp name, with full path
     * @throws Exception any axception thrown during test.
     */
    @Test
    public void doTest() throws Exception
    {
        // test keep
        WebRequest request = new GetMethodWebRequest(getJspUrl(getJspName()));

        // test remove
        ParamEncoder encoder = new ParamEncoder("table");
        String mediaParameter = encoder.encodeParameterName(TableTagParameters.PARAMETER_EXPORTTYPE);

        request.setParameter(mediaParameter, Integer.toString(MediaTypeEnum.XML.getCode()));

        WebResponse response = runner.getResponse(request);

        String encoding = response.getCharacterSet();

        Assert.assertEquals("Encoding is not utf-8 as expected", "utf-8", encoding);

    }

}