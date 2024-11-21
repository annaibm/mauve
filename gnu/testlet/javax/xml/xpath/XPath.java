/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.xml.xpath;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.StringReader;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XPath
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            harness.checkPoint("jaxp-1.3-ch13s2.2.4");
            harness.check(this.nodeset("//*", "<o/>") instanceof NodeList);
        }
        catch (XPathExpressionException e) {
            harness.debug(e);
            harness.check(false);
        }
    }

    private Object nodeset(String expr, String document) throws XPathExpressionException {
        return this.eval(expr, document, XPathConstants.NODESET);
    }

    private Object eval(String expr, String document, QName returnType) throws XPathExpressionException {
        XPathFactory factory = XPathFactory.newInstance();
        javax.xml.xpath.XPath xpath = factory.newXPath();
        return xpath.evaluate(expr, this.source(document), returnType);
    }

    private InputSource source(String xml) {
        return new InputSource(new StringReader(xml));
    }
}

