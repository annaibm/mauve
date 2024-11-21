/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.AbstractDocument.BranchElement;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;

public class getStartOffset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testEmptyBranchElement(harness);
        this.testOneLeafElement(harness);
        this.testCachedValue(harness);
    }

    private void testEmptyBranchElement(TestHarness h) {
        PlainDocument doc;
        PlainDocument plainDocument = doc = new PlainDocument();
        plainDocument.getClass();
        AbstractDocument.BranchElement b = new AbstractDocument.BranchElement(plainDocument, null, null);
        try {
            b.getStartOffset();
            h.fail("emptyBranchElement");
        }
        catch (NullPointerException ex) {
            h.check(true);
        }
    }

    private void testOneLeafElement(TestHarness h) {
        PlainDocument doc;
        PlainDocument plainDocument = doc = new PlainDocument();
        plainDocument.getClass();
        AbstractDocument.BranchElement b = new AbstractDocument.BranchElement(plainDocument, null, null);
        PlainDocument plainDocument2 = doc;
        plainDocument2.getClass();
        AbstractDocument.LeafElement l = new AbstractDocument.LeafElement(plainDocument2, b, null, 10, 20);
        b.replace(0, 0, new Element[]{l});
        h.check(b.getStartOffset(), 10);
    }

    private void testCachedValue(TestHarness h) {
        PlainDocument doc;
        PlainDocument plainDocument = doc = new PlainDocument();
        plainDocument.getClass();
        AbstractDocument.BranchElement b = new AbstractDocument.BranchElement(plainDocument, null, null);
        PlainDocument plainDocument2 = doc;
        plainDocument2.getClass();
        AbstractDocument.LeafElement l = new AbstractDocument.LeafElement(plainDocument2, b, null, 10, 20);
        b.replace(0, 0, new Element[]{l});
        h.check(b.getStartOffset(), 10);
        b.replace(0, 1, new Element[0]);
        h.check(b.getElementCount(), 0);
        h.check(b.getStartOffset(), 10);
    }
}

