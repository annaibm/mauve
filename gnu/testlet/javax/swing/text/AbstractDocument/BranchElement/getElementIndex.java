/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.AbstractDocument.BranchElement;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;

public class getElementIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testBeyondBoundary(harness);
    }

    private void testBeyondBoundary(TestHarness h) {
        PlainDocument doc = new PlainDocument();
        try {
            doc.insertString(0, "hello\n", null);
        }
        catch (BadLocationException ex) {
            h.fail(ex.getMessage());
        }
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementIndex(6), 1);
    }
}

