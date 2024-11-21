/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.GapContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.GapContent;
import javax.swing.text.Position;

public class remove
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testGeneral(harness);
        this.testRemoveLast(harness);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void testGeneral(TestHarness harness) {
        GapContent gc = new GapContent();
        try {
            gc.insertString(0, "ABCDEFG");
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(gc.length(), 8);
        boolean pass = false;
        try {
            gc.remove(-1, 3);
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
            gc.remove(99, 1);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            gc.remove(7, 1);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        harness.check(gc.length(), 8);
        pass = true;
        try {
            gc.remove(0, 0);
        }
        catch (BadLocationException e) {
            pass = false;
        }
        harness.check(pass);
        harness.check(gc.length(), 8);
        int offset2 = 0;
        try {
            gc = new GapContent();
            gc.insertString(0, "abc\ndef\n");
            Position pos = gc.createPosition(4);
            gc.remove(4, 1);
            offset2 = pos.getOffset();
        }
        catch (BadLocationException ble) {
            offset2 = -1;
        }
        finally {
            harness.check(offset2, 4);
        }
    }

    public void testRemoveLast(TestHarness harness) {
        harness.checkPoint("testRemoveLast");
        GapContent gc = new GapContent();
        harness.check(gc.length(), 1);
        boolean pass = false;
        try {
            gc.remove(0, 1);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

