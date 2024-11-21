/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.GapContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.GapContent;
import javax.swing.text.Segment;

public class getChars
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GapContent gc = new GapContent();
        Segment seg = new Segment();
        try {
            gc.getChars(0, 1, seg);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(seg.offset, 0);
        harness.check(seg.count, 1);
        harness.check(seg.array[0], 10);
        boolean pass = false;
        try {
            gc.getChars(0, 2, seg);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        try {
            gc.insertString(0, "ABCDEFG");
        }
        catch (BadLocationException e) {
            // empty catch block
        }
        harness.check(gc.length(), 8);
        pass = false;
        try {
            gc.getChars(-1, 3, seg);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            gc.getChars(99, 1, seg);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            gc.getChars(0, 99, seg);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        try {
            gc.getChars(1, 0, seg);
        }
        catch (BadLocationException e) {
            // empty catch block
        }
        harness.check(seg.offset, 1);
        harness.check(seg.count, 0);
        pass = false;
        try {
            gc.getChars(0, 1, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        catch (BadLocationException e) {
            // empty catch block
        }
        harness.check(pass);
        Segment seg2 = new Segment();
        Segment seg3 = new Segment();
        GapContent gc2 = new GapContent();
        try {
            gc2.insertString(0, "XYZ");
            gc2.getChars(0, 3, seg2);
            seg2.array[1] = 53;
            gc2.getChars(0, 3, seg3);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(seg2.array[1], 53);
        harness.check(seg3.array[1], 53);
    }
}

