/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.GapContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.GapContent;
import javax.swing.text.PlainDocument;
import javax.swing.text.Position;

public class PositionTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testSimple(harness);
        this.testComplex(harness);
        this.testBorderCase(harness);
    }

    void testSimple(TestHarness harness) {
        harness.checkPoint("testSimple");
        GapContent c = new GapContent();
        try {
            Position p1 = c.createPosition(0);
            Position p2 = c.createPosition(1);
            harness.check(p1.getOffset(), 0);
            harness.check(p2.getOffset(), 1);
            c.insertString(0, "hello");
            harness.check(p1.getOffset(), 0);
            harness.check(p2.getOffset(), 6);
            c.remove(0, 5);
            harness.check(p1.getOffset(), 0);
            harness.check(p2.getOffset(), 1);
        }
        catch (BadLocationException ex) {
            harness.fail("BadLocationException");
            harness.debug(ex);
        }
    }

    void testComplex(TestHarness harness) {
        harness.checkPoint("testComplex");
        GapContent c = new GapContent();
        try {
            Position p1 = c.createPosition(0);
            Position p2 = c.createPosition(1);
            harness.check(p1.getOffset(), 0);
            harness.check(p2.getOffset(), 1);
            c.insertString(0, "abcdefghijklmno");
            harness.check(p1.getOffset(), 0);
            harness.check(p2.getOffset(), 16);
            c.insertString(5, "12345");
            harness.check(p1.getOffset(), 0);
            harness.check(p2.getOffset(), 21);
            PlainDocument doc = new PlainDocument();
            doc.insertString(0, "cdefgh", null);
            Position s = doc.createPosition(1);
            harness.check(s.getOffset(), 1);
            doc.insertString(0, "a", null);
            harness.check(s.getOffset(), 2);
            Position a = doc.createPosition(1);
            harness.check(a.getOffset(), 1);
            doc.insertString(1, "b", null);
            harness.check(s.getOffset(), 3);
            harness.check(a.getOffset(), 2);
        }
        catch (BadLocationException ex) {
            harness.fail("BadLocationException");
            harness.debug(ex);
        }
    }

    void testBorderCase(TestHarness h) {
        h.checkPoint("border case");
        try {
            PlainDocument doc = new PlainDocument();
            doc.insertString(0, "One Three Four", null);
            Position pos = doc.createPosition(4);
            doc.insertString(4, "Two ", null);
            h.check(pos.getOffset(), 8);
        }
        catch (BadLocationException ex) {
            h.fail("BadLocationException thrown");
        }
    }
}

