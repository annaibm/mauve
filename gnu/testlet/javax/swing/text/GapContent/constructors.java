/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.GapContent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.GapContent.MyGapContent;
import javax.swing.text.BadLocationException;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        MyGapContent gc = new MyGapContent();
        harness.check(gc.length(), 1);
        boolean pass = false;
        try {
            pass = gc.getString(0, 1).equals("\n");
        }
        catch (BadLocationException e) {
            harness.fail(e.toString());
        }
        harness.check(pass);
        harness.check(gc.getArrayLength(), 10);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(int)");
        MyGapContent gc = new MyGapContent(10);
        harness.check(gc.length(), 1);
        boolean pass = false;
        try {
            pass = gc.getString(0, 1).equals("\n");
        }
        catch (BadLocationException e) {
            harness.fail(e.toString());
        }
        harness.check(pass);
        harness.check(gc.getArrayLength(), 10);
        int length2 = -1;
        int arrayLength = -1;
        MyGapContent gc2 = null;
        try {
            gc2 = new MyGapContent(0);
            length2 = gc2.length();
            arrayLength = gc2.getArrayLength();
        }
        catch (Exception exception) {
            // empty catch block
        }
        harness.check(length2, 1);
        harness.check(arrayLength, 2);
        length2 = -1;
        arrayLength = -1;
        gc2 = null;
        try {
            gc2 = new MyGapContent(0);
            length2 = gc2.length();
            arrayLength = gc2.getArrayLength();
        }
        catch (Exception exception) {
            // empty catch block
        }
        harness.check(length2, 1);
        harness.check(arrayLength, 2);
    }
}

