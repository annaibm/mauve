/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StringContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.StringContent;

public class length
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringContent sc = new StringContent();
        harness.check(sc.length(), 1);
        try {
            sc.insertString(0, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            harness.check(sc.length(), 27);
            sc.remove(0, 3);
            harness.check(sc.length(), 24);
            sc.insertString(4, "123");
            harness.check(sc.length(), 27);
            sc.remove(20, 5);
            harness.check(sc.length(), 22);
        }
        catch (BadLocationException e) {
            harness.fail(e.toString());
        }
    }
}

