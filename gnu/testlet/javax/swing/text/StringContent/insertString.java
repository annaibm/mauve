/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StringContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.StringContent;

public class insertString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringContent sc = new StringContent();
        try {
            sc.insertString(0, "ABC");
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(sc.length(), 4);
        boolean pass = false;
        try {
            sc.insertString(-1, "XYZ");
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        try {
            sc.insertString(3, "XYZ");
        }
        catch (BadLocationException e) {
            // empty catch block
        }
        harness.check(sc.length(), 7);
        pass = false;
        try {
            sc.insertString(7, "XYZ");
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        try {
            sc.insertString(0, "");
        }
        catch (BadLocationException e) {
            // empty catch block
        }
        harness.check(sc.length(), 7);
        pass = false;
        try {
            sc.insertString(0, null);
        }
        catch (BadLocationException e) {
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

