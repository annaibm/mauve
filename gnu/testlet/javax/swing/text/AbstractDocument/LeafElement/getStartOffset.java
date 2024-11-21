/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.AbstractDocument.LeafElement;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class getStartOffset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testIllegalDocumentLocation(harness);
        this.testContentChange(harness);
    }

    private void testIllegalDocumentLocation(TestHarness h) {
        PlainDocument doc;
        h.checkPoint("illegalDocumentLocation");
        PlainDocument plainDocument = doc = new PlainDocument();
        plainDocument.getClass();
        AbstractDocument.LeafElement l = new AbstractDocument.LeafElement(plainDocument, null, null, 10, 20);
        h.check(doc.getLength(), 0);
        h.check(l.getStartOffset(), 10);
    }

    private void testContentChange(TestHarness h) {
        h.checkPoint("contentChange");
        try {
            PlainDocument doc = new PlainDocument();
            doc.insertString(0, "hallo", null);
            PlainDocument plainDocument = doc;
            plainDocument.getClass();
            AbstractDocument.LeafElement l = new AbstractDocument.LeafElement(plainDocument, null, null, 20, 5);
            h.check(l.getStartOffset(), 20);
            doc.insertString(0, "hiyo", null);
            h.check(l.getStartOffset(), 24);
        }
        catch (BadLocationException ex) {
            h.fail("BadLocationException");
        }
    }
}

