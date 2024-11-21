/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.PlainDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.text.Position;

public class createPosition
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("test1");
        PlainDocument d = new PlainDocument();
        try {
            Position p0 = d.createPosition(0);
            harness.check(p0.getOffset(), 0);
            Position p1 = d.createPosition(1);
            harness.check(p1.getOffset(), 1);
            d.insertString(0, "ABC", null);
            harness.check(p0.getOffset(), 0);
            harness.check(p1.getOffset(), 4);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("test2");
        PlainDocument d = new PlainDocument();
        try {
            d.insertString(0, "ABC", null);
            Position p0 = d.createPosition(0);
            harness.check(p0.getOffset(), 0);
            Position p1 = d.createPosition(1);
            harness.check(p1.getOffset(), 1);
            Position p2 = d.createPosition(3);
            harness.check(p2.getOffset(), 3);
            Position p3 = d.createPosition(4);
            harness.check(p3.getOffset(), 4);
            d.insertString(1, "XYZ", null);
            harness.check(p0.getOffset(), 0);
            harness.check(p1.getOffset(), 4);
            harness.check(p2.getOffset(), 6);
            harness.check(p3.getOffset(), 7);
            d.remove(2, 3);
            harness.check(p0.getOffset(), 0);
            harness.check(p1.getOffset(), 2);
            harness.check(p2.getOffset(), 3);
            harness.check(p3.getOffset(), 4);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
    }
}

