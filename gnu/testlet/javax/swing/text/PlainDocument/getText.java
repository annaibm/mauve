/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.PlainDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.text.Segment;

public class getText
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("(int, int)");
        PlainDocument d = new PlainDocument();
        try {
            d.insertString(0, "XYZ", null);
            harness.check(d.getText(0, 3).equals("XYZ"));
        }
        catch (BadLocationException e) {
            harness.fail(e.toString());
        }
        try {
            harness.check(d.getText(0, 4).equals("XYZ\n"));
        }
        catch (BadLocationException e) {
            harness.fail(e.toString());
        }
        try {
            d.getText(0, 5);
            harness.check(false);
        }
        catch (BadLocationException e) {
            harness.check(true);
        }
        try {
            d.insertString(0, "ABCDEFG", null);
        }
        catch (BadLocationException e) {
            // empty catch block
        }
        harness.check(d.getLength(), 10);
        boolean pass = false;
        try {
            d.getText(-1, 3);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            d.getText(99, 1);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            d.getText(0, 99);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        try {
            harness.check(d.getText(1, 0).equals(""));
        }
        catch (BadLocationException e) {
            harness.fail(e.toString());
        }
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int, int, Segment)");
        PlainDocument d = new PlainDocument();
        Segment seg = new Segment();
        try {
            d.getText(0, 1, seg);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(seg.offset, 0);
        harness.check(seg.count, 1);
        harness.check(seg.array[0], 10);
        boolean pass = false;
        try {
            d.getText(0, 2, seg);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        try {
            d.insertString(0, "ABCDEFG", null);
        }
        catch (BadLocationException e) {
            // empty catch block
        }
        harness.check(d.getLength(), 7);
        pass = false;
        try {
            d.getText(-1, 3, seg);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            d.getText(99, 1, seg);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            d.getText(0, 99, seg);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        try {
            d.getText(1, 0, seg);
        }
        catch (BadLocationException e) {
            // empty catch block
        }
        harness.check(seg.offset, 1);
        harness.check(seg.count, 0);
        pass = false;
        try {
            d.getText(0, 1, null);
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
        PlainDocument d2 = new PlainDocument();
        try {
            d2.insertString(0, "XYZ", null);
            d2.getText(0, 3, seg2);
            seg2.array[1] = 53;
            d2.getText(0, 3, seg3);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(seg2.array[1], 53);
        harness.check(seg3.array[1], 53);
    }
}

