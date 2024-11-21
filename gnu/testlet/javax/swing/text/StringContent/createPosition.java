/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StringContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.StringContent;

public class createPosition
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringContent sc = new StringContent();
        harness.check(sc.length(), 1);
        try {
            sc.insertString(0, "ABC");
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        boolean pass = false;
        try {
            sc.createPosition(-1);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        Position p = null;
        try {
            p = sc.createPosition(3);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(p.getOffset(), 3);
        try {
            p = sc.createPosition(4);
        }
        catch (BadLocationException e) {
            // empty catch block
        }
        harness.check(p.getOffset(), 4);
        pass = false;
        try {
            p = sc.createPosition(5);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

