/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StringContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.StringContent;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        StringContent sc = new StringContent();
        harness.check(sc.length(), 1);
        boolean pass = false;
        try {
            pass = sc.getString(0, 1).equals("\n");
        }
        catch (BadLocationException e) {
            harness.fail(e.toString());
        }
        harness.check(pass);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(int)");
        StringContent sc = new StringContent(10);
        harness.check(sc.length(), 1);
        boolean pass = false;
        try {
            pass = sc.getString(0, 1).equals("\n");
        }
        catch (BadLocationException e) {
            harness.fail(e.toString());
        }
        harness.check(pass);
    }
}

