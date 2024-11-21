/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.GapContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.GapContent;

public class length
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GapContent gc = new GapContent();
        harness.check(gc.length(), 1);
        try {
            gc.insertString(0, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            harness.check(gc.length(), 27);
            gc.remove(0, 3);
            harness.check(gc.length(), 24);
            gc.insertString(4, "123");
            harness.check(gc.length(), 27);
            gc.remove(20, 5);
            harness.check(gc.length(), 22);
        }
        catch (BadLocationException e) {
            harness.fail(e.toString());
        }
    }
}

