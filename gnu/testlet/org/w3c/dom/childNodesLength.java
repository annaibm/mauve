/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.org.w3c.dom;

import gnu.testlet.ResourceNotFoundException;
import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Notation;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

public class childNodesLength
implements Testlet {
    TestHarness harness;

    private void checkNode(Node node) {
        int nChilds = node.getChildNodes().getLength();
        if (node instanceof CDATASection || node instanceof Comment || node instanceof DocumentType || node instanceof Notation || node instanceof ProcessingInstruction || node instanceof Text) {
            this.harness.check(nChilds == 0, node.getClass().getName());
        }
    }

    private void recurse(NodeList nl) {
        for (int i = 0; i < nl.getLength(); ++i) {
            NodeList nl2;
            int nChilds;
            Node node = nl.item(i);
            if (node == null) continue;
            this.checkNode(node);
            if (node instanceof DocumentType) {
                DocumentType dt = (DocumentType)node;
                NamedNodeMap nnm = dt.getNotations();
                for (int j = 0; j < nnm.getLength(); ++j) {
                    this.checkNode((Notation)nnm.item(j));
                }
            }
            if ((nChilds = (nl2 = node.getChildNodes()).getLength()) <= 0) continue;
            this.recurse(nl2);
        }
    }

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        }
        catch (ParserConfigurationException pce) {
            harness.debug(pce);
            harness.check(false);
            return;
        }
        InputStream input = null;
        try {
            input = harness.getResourceStream("gnu#testlet#org#w3c#dom#test.xml");
        }
        catch (ResourceNotFoundException rnfe) {
            harness.debug(rnfe);
            harness.check(false);
            return;
        }
        Document document = null;
        try {
            document = db.parse(input);
        }
        catch (Exception e) {
            harness.debug(e);
            harness.check(false);
            return;
        }
        this.recurse(document.getChildNodes());
    }
}

