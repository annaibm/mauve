/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.PlainDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import javax.swing.text.Position;

public class remove
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testArguments(harness);
        this.testPositions(harness);
        this.testBehavior(harness);
    }

    public void testArguments(TestHarness harness) {
        harness.checkPoint("testArguments");
        PlainDocument d = new PlainDocument();
        try {
            d.insertString(0, "ABC", null);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        boolean pass = false;
        try {
            d.remove(-1, 1);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            d.remove(4, 0);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            d.remove(2, 99);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            d.remove(2, -1);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testPositions(TestHarness harness) {
        harness.checkPoint("testPositions");
        PlainDocument d = new PlainDocument();
        try {
            d.insertString(0, "ABCDEF", null);
            Position p0 = d.createPosition(0);
            harness.check(p0.getOffset(), 0);
            Position p1 = d.createPosition(1);
            harness.check(p1.getOffset(), 1);
            Position p2 = d.createPosition(2);
            harness.check(p2.getOffset(), 2);
            Position p3 = d.createPosition(3);
            harness.check(p3.getOffset(), 3);
            Position p4 = d.createPosition(4);
            harness.check(p4.getOffset(), 4);
            Position p5 = d.createPosition(5);
            harness.check(p5.getOffset(), 5);
            Position p6 = d.createPosition(6);
            harness.check(p6.getOffset(), 6);
            d.remove(2, 2);
            harness.check(p0.getOffset(), 0);
            harness.check(p1.getOffset(), 1);
            harness.check(p2.getOffset(), 2);
            harness.check(p3.getOffset(), 2);
            harness.check(p4.getOffset(), 2);
            harness.check(p5.getOffset(), 3);
            harness.check(p6.getOffset(), 4);
            d.remove(0, 1);
            harness.check(p0.getOffset(), 0);
            harness.check(p1.getOffset(), 0);
            harness.check(p2.getOffset(), 1);
            harness.check(p3.getOffset(), 1);
            harness.check(p4.getOffset(), 1);
            harness.check(p5.getOffset(), 2);
            harness.check(p6.getOffset(), 3);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void testBehavior(TestHarness harness) {
        harness.checkPoint("testArguments");
        PlainDocument pd = new PlainDocument();
        int index0 = -1;
        int index1 = -1;
        try {
            pd.insertString(0, "abc\ndef\n", null);
            pd.remove(2, 1);
            Element re = pd.getDefaultRootElement();
            index0 = re.getElementIndex(2);
            index1 = re.getElementIndex(3);
        }
        catch (BadLocationException ble) {
            index0 = -1;
            index1 = -1;
        }
        finally {
            harness.check(index0, 0);
            harness.check(index1, 1);
        }
    }
}

