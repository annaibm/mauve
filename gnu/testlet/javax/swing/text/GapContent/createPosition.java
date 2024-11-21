/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.GapContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.GapContent;
import javax.swing.text.Position;

public class createPosition
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GapContent gc = new GapContent();
        harness.check(gc.length(), 1);
        try {
            gc.insertString(0, "ABC");
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        boolean pass = false;
        try {
            gc.createPosition(-1);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        Position p = null;
        try {
            p = gc.createPosition(3);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(p.getOffset(), 3);
        try {
            p = gc.createPosition(4);
        }
        catch (BadLocationException e) {
            // empty catch block
        }
        harness.check(p.getOffset(), 4);
        pass = false;
        try {
            p = gc.createPosition(5);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

