/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StringContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.StringContent;

public class getString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringContent sc = new StringContent();
        boolean pass = false;
        try {
            pass = sc.getString(0, 1).equals("\n");
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(pass);
        pass = false;
        try {
            sc.getString(0, 2);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        try {
            sc.insertString(0, "ABCDEFG");
        }
        catch (BadLocationException e) {
            // empty catch block
        }
        harness.check(sc.length(), 8);
        pass = false;
        try {
            sc.getString(-1, 3);
        }
        catch (StringIndexOutOfBoundsException e) {
            pass = false;
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            sc.getString(99, 1);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            sc.getString(0, 99);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            pass = sc.getString(1, 0).equals("");
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(pass);
    }
}

