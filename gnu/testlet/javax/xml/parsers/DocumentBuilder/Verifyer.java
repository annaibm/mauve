/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.xml.parsers.DocumentBuilder;

import gnu.testlet.TestHarness;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class Verifyer {
    String EOLN = " ";
    TestHarness harness;
    boolean IDENTATION = false;

    Verifyer() {
    }

    String getImage(Node node) {
        StringBuffer b = new StringBuffer();
        this.print(b, node, 0);
        return b.toString().trim();
    }

    void print(StringBuffer stream, Node node, int ident) {
        NamedNodeMap attributes;
        StringBuffer tab = new StringBuffer();
        stream.append(this.EOLN);
        if (this.IDENTATION) {
            for (int i = 0; i < ident; ++i) {
                tab.append(' ');
            }
        }
        if (node == null) {
            stream.append(tab + " null node");
            return;
        }
        String nn = node.getNodeName();
        if (node.getNamespaceURI() != null) {
            nn = node.getNamespaceURI() + ":" + nn;
        }
        stream.append(tab + nn);
        if (node.getNodeValue() != null) {
            stream.append(this.EOLN);
            stream.append(tab + " = '" + node.getNodeValue() + "'");
        }
        if ((attributes = node.getAttributes()) != null && attributes.getLength() != 0) {
            stream.append(' ');
            for (int i = 0; i < attributes.getLength(); ++i) {
                Node a = attributes.item(i);
                stream.append(a.getNodeName() + "='" + a.getNodeValue() + "'");
            }
        }
        ident += 4;
        NodeList childs = node.getChildNodes();
        if (childs != null) {
            for (int i = 0; i < childs.getLength(); ++i) {
                this.print(stream, childs.item(i), ident);
            }
        }
    }

    void verify(String xml, String image, String message) {
        this.harness.checkPoint(message);
        try {
            boolean validation = false;
            boolean ignoreWhitespace = false;
            boolean ignoreComments = false;
            boolean putCDATAIntoText = false;
            boolean createEntityRefs = false;
            boolean namespaces = true;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setValidating(validation);
            dbf.setIgnoringComments(ignoreComments);
            dbf.setIgnoringElementContentWhitespace(ignoreWhitespace);
            dbf.setCoalescing(putCDATAIntoText);
            dbf.setNamespaceAware(namespaces);
            dbf.setExpandEntityReferences(!createEntityRefs);
            DocumentBuilder b = dbf.newDocumentBuilder();
            Document d = b.parse(new ByteArrayInputStream(xml.getBytes()));
            String result = this.getImage(d);
            if (!result.equals(image)) {
                System.out.println("Exp: " + image);
                System.out.println("Rez: " + result);
                this.harness.check(result, image, message);
            }
        }
        catch (Exception ex) {
            if (ex != null) {
                this.harness.fail(message + ":" + ex.getClass().getName() + ":" + ex.getMessage());
            }
            this.harness.fail(message + ": null exception");
        }
    }
}

