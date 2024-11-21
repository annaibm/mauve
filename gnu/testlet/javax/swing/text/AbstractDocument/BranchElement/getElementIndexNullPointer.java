/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.AbstractDocument.BranchElement;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.AbstractDocument;
import javax.swing.text.PlainDocument;

public class getElementIndexNullPointer
implements Testlet {
    @Override
    public void test(TestHarness h) {
        PlainDocument doc;
        PlainDocument plainDocument = doc = new PlainDocument();
        plainDocument.getClass();
        AbstractDocument.BranchElement b = new AbstractDocument.BranchElement(plainDocument, null, null);
        try {
            b.getElementIndex(0);
            h.fail("AbstractDocument.BranchElement.getElementIndex should throw NPE when it has no children");
        }
        catch (NullPointerException ex) {
            h.check(true);
        }
    }
}

