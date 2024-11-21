/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StringContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Segment;
import javax.swing.text.StringContent;

public class getChars
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringContent sc = new StringContent();
        char[] ch = new char[]{'A', 'B', 'C'};
        Segment seg = new Segment(ch, 0, 3);
        try {
            sc.getChars(0, 1, seg);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(seg.offset, 0);
        harness.check(seg.count, 1);
        harness.check(seg.array != ch);
        harness.check(seg.array[0], 10);
        boolean pass = false;
        try {
            sc.getChars(0, 2, seg);
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
            sc.getChars(-1, 3, seg);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            sc.getChars(99, 1, seg);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            sc.getChars(0, 99, seg);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        try {
            sc.getChars(1, 0, seg);
        }
        catch (BadLocationException e) {
            // empty catch block
        }
        harness.check(seg.offset, 1);
        harness.check(seg.count, 0);
        pass = false;
        try {
            sc.getChars(0, 1, null);
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
        StringContent sc2 = new StringContent();
        try {
            sc2.insertString(0, "XYZ");
            sc2.getChars(0, 3, seg2);
            seg2.array[1] = 53;
            sc2.getChars(0, 3, seg3);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(seg2.array[1], 53);
        harness.check(seg3.array[1], 53);
    }
}

