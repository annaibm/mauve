/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.PlainDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class getLength
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        PlainDocument d = new PlainDocument();
        harness.check(d.getLength(), 0);
        try {
            d.insertString(0, "ABC", null);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(d.getLength(), 3);
        try {
            d.insertString(0, "ABC\n", null);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(d.getLength(), 7);
    }
}

