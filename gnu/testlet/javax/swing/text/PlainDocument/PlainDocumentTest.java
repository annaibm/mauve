/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.PlainDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;

public class PlainDocumentTest
implements Testlet {
    private void checkElement(TestHarness harness, Element elem, AttributeSet attributes, int children2, Element parent, int p0, int p1, boolean leaf, String name2) {
        if (elem == null) {
            harness.debug("element is null");
            return;
        }
        harness.check(elem.getAttributes() != attributes, "unexpected value for Element.getAttributes()");
        if (elem.getAttributes() != null) {
            harness.check(elem.getAttributes().getAttributeCount(), 0, "number of attributes");
        }
        harness.check(elem.getElementCount(), children2, "number of children");
        harness.check(elem.getParentElement() == parent, "wrong parent");
        harness.check(elem.getStartOffset(), p0, "start offset");
        harness.check(elem.getEndOffset(), p1, "end offset");
        harness.check(elem.isLeaf(), leaf, "element is leaf element");
        harness.check(elem.getName(), name2, "element name");
    }

    @Override
    public void test(TestHarness harness) {
        PlainDocument doc = new PlainDocument();
        Element root = doc.getDefaultRootElement();
        this.checkElement(harness, root, null, 1, null, 0, doc.getLength() + 1, false, "paragraph");
        Element elem = root.getElement(0);
        this.checkElement(harness, elem, null, 0, root, 0, doc.getLength() + 1, true, "content");
        try {
            doc.insertString(0, "This is a test", null);
            harness.check(doc.getText(0, doc.getLength()), "This is a test", "insertString");
            harness.check(doc.getDefaultRootElement().getStartOffset(), 0, "start offset");
            harness.check(doc.getDefaultRootElement().getEndOffset(), 15, "end offset (insertString)");
            doc.insertString(14, "case", null);
            harness.check(doc.getText(0, doc.getLength()), "This is a testcase", "insertString");
            harness.check(doc.getDefaultRootElement().getStartOffset(), 0, "start offset");
            harness.check(doc.getDefaultRootElement().getEndOffset(), 19, "end offset (insertString)");
            doc.insertString(10, "little ", null);
            harness.check(doc.getText(0, doc.getLength()), "This is a little testcase", "insertString");
            harness.check(doc.getDefaultRootElement().getStartOffset(), 0, "start offset");
            harness.check(doc.getDefaultRootElement().getEndOffset(), 26, "end offset (insertString)");
        }
        catch (Exception e) {
            harness.debug(e);
            harness.fail("unexpected exception");
        }
        root = doc.getDefaultRootElement();
        this.checkElement(harness, root, null, 1, null, 0, doc.getLength() + 1, false, "paragraph");
        elem = root.getElement(0);
        this.checkElement(harness, elem, null, 0, root, 0, doc.getLength() + 1, true, "content");
        elem = doc.getParagraphElement(0);
        this.checkElement(harness, elem, null, 0, root, 0, doc.getLength() + 1, true, "content");
        harness.check(elem.getElement(0) == null, "element is null");
    }
}

