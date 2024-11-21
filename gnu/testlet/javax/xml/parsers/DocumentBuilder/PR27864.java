/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.xml.parsers.DocumentBuilder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PR27864
implements Testlet {
    String xml = "  <main>  <element>    <alwaysThere/>  </element>  <element>    <alwaysThere>      <sometimesThere>foo</sometimesThere>    </alwaysThere>  </element>  <element>    <alwaysThere>      <sometimesThere>bar</sometimesThere>    </alwaysThere>  </element></main>";

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getElementsByTagName");
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder b = dbf.newDocumentBuilder();
            Document d = b.parse(new ByteArrayInputStream(this.xml.getBytes()));
            Element element0 = (Element)d.getElementsByTagName("element").item(0);
            Element always = (Element)element0.getElementsByTagName("alwaysThere").item(0);
            NodeList st_nl = always.getElementsByTagName("sometimesThere");
            harness.check(st_nl.getLength(), 0);
        }
        catch (IOException ioe) {
            harness.fail("IOException occured");
        }
        catch (DOMException de) {
            harness.fail("DOMException occured");
        }
        catch (SAXException saxe) {
            harness.fail("SAXException occured");
        }
        catch (ParserConfigurationException pce) {
            harness.fail("ParserConfigurationException occured");
        }
    }
}

