/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StringContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.StringContent;

public class remove
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testGeneral(harness);
        this.testRemoveLast(harness);
    }

    public void testGeneral(TestHarness harness) {
        StringContent sc = new StringContent();
        try {
            sc.insertString(0, "ABCDEFG");
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(sc.length(), 8);
        boolean pass = false;
        try {
            sc.remove(-1, 3);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        catch (StringIndexOutOfBoundsException e) {
            pass = false;
        }
        harness.check(pass);
        pass = false;
        try {
            sc.remove(99, 1);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            sc.remove(7, 1);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        harness.check(sc.length(), 8);
        pass = true;
        try {
            sc.remove(0, 0);
        }
        catch (BadLocationException e) {
            pass = false;
        }
        harness.check(pass);
        harness.check(sc.length(), 8);
    }

    public void testRemoveLast(TestHarness harness) {
        harness.checkPoint("testRemoveLast");
        StringContent sc = new StringContent();
        harness.check(sc.length(), 1);
        boolean pass = false;
        try {
            sc.remove(0, 1);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

