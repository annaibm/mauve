/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.AbstractDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.GapContent;

public class AbstractDocumentTest
implements Testlet {
    private void testContentHandling(TestHarness harness) {
        DocumentImpl doc = new DocumentImpl();
        harness.checkPoint("testContentHandling");
        try {
            harness.check(doc.getText(0, doc.getLength()).equals(""));
            doc.insertString(0, "This is a test", null);
            harness.check(doc.getText(0, doc.getLength()).equals("This is a test"));
            doc.insertString(10, "little ", null);
            harness.check(doc.getText(0, doc.getLength()).equals("This is a little test"));
            doc.insertString(21, "case", null);
            harness.check(doc.getText(0, doc.getLength()).equals("This is a little testcase"));
        }
        catch (Exception e) {
            harness.fail("unexpected exception");
        }
    }

    private void checkElement(TestHarness harness, Element elem, AttributeSet attributes, int children2, Element parent) {
        harness.check(elem.getElementCount() == children2, "unexpected number of children: " + elem.getElementCount());
        harness.check(elem.getParentElement() == parent, "Wrong parent");
    }

    private void testCreateLeafElement(TestHarness harness) {
        DocumentImpl doc = new DocumentImpl();
        harness.checkPoint("testCreateLeafElement");
        Element elem = doc.createLeafElement(null, null, 0, 1);
        this.checkElement(harness, elem, null, 0, null);
    }

    private void testCreateBranchElement(TestHarness harness) {
        DocumentImpl doc = new DocumentImpl();
        harness.checkPoint("testCreateBranchElement 1");
        Element elem = doc.createBranchElement(null, null);
        this.checkElement(harness, elem, null, 0, null);
        harness.checkPoint("testCreateBranchElement 2");
        Element parent = elem;
        elem = doc.createBranchElement(parent, null);
        this.checkElement(harness, parent, null, 0, null);
        this.checkElement(harness, elem, null, 0, parent);
        harness.checkPoint("testCreateBranchElement 3");
        Element elem2 = doc.createBranchElement(parent, null);
        this.checkElement(harness, parent, null, 0, null);
        this.checkElement(harness, elem2, null, 0, parent);
    }

    @Override
    public void test(TestHarness harness) {
        this.testCreateBranchElement(harness);
        this.testCreateLeafElement(harness);
        this.testContentHandling(harness);
    }

    public class DocumentImpl
    extends AbstractDocument {
        public DocumentImpl() {
            super(new GapContent());
        }

        @Override
        public Element getDefaultRootElement() {
            return null;
        }

        @Override
        public Element getParagraphElement(int index) {
            return this.getDefaultRootElement();
        }

        @Override
        public Element createBranchElement(Element parent, AttributeSet attributes) {
            return super.createBranchElement(parent, attributes);
        }

        @Override
        public Element createLeafElement(Element parent, AttributeSet attributes, int p0, int p1) {
            return super.createLeafElement(parent, attributes, p0, p1);
        }
    }
}

