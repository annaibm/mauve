/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.AWTKeyStroke;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTKeyStroke;

public class getAWTKeyStroke
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
        this.testMethod3(harness);
        this.testMethod4(harness);
        this.testMethod5(harness);
    }

    private void testMethod1(TestHarness harness) {
        harness.checkPoint("(char)");
        AWTKeyStroke ks = AWTKeyStroke.getAWTKeyStroke('s');
        harness.check(ks.getKeyEventType(), 400);
        harness.check(ks.getKeyChar(), 115);
        harness.check(ks.getModifiers(), 0);
        harness.check(ks.isOnKeyRelease(), false);
    }

    private void testMethod2(TestHarness harness) {
        harness.checkPoint("(Character, int)");
        AWTKeyStroke ks = AWTKeyStroke.getAWTKeyStroke(new Character('s'), 192);
        harness.check(ks.getKeyEventType(), 400);
        harness.check(ks.getKeyChar(), 115);
        harness.check(ks.getModifiers(), 195);
        harness.check(ks.isOnKeyRelease(), false);
        try {
            ks = AWTKeyStroke.getAWTKeyStroke(null, 0);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void testMethod3(TestHarness harness) {
        harness.checkPoint("(int, int)");
        AWTKeyStroke ks = AWTKeyStroke.getAWTKeyStroke(10, 192);
        harness.check(ks.getKeyEventType(), 401);
        harness.check(ks.getKeyChar(), 65535);
        harness.check(ks.getModifiers(), 195);
        harness.check(ks.isOnKeyRelease(), false);
    }

    private void testMethod4(TestHarness harness) {
        harness.checkPoint("(int, int, boolean)");
        AWTKeyStroke ks = AWTKeyStroke.getAWTKeyStroke(10, 192, true);
        harness.check(ks.getKeyEventType(), 402);
        harness.check(ks.getKeyChar(), 65535);
        harness.check(ks.getModifiers(), 195);
        harness.check(ks.isOnKeyRelease(), true);
    }

    private void testMethod5(TestHarness harness) {
        harness.checkPoint("(String)");
        AWTKeyStroke ks = AWTKeyStroke.getAWTKeyStroke("INSERT");
        AWTKeyStroke expected = AWTKeyStroke.getAWTKeyStroke(155, 0);
        harness.check(ks, expected);
        ks = AWTKeyStroke.getAWTKeyStroke("control DELETE");
        expected = AWTKeyStroke.getAWTKeyStroke(127, 128);
        harness.check(ks, expected);
        expected = AWTKeyStroke.getAWTKeyStroke(127, 2);
        harness.check(ks, expected);
        ks = AWTKeyStroke.getAWTKeyStroke("alt shift X");
        expected = AWTKeyStroke.getAWTKeyStroke(88, 576);
        harness.check(ks, expected);
        expected = AWTKeyStroke.getAWTKeyStroke(88, 9);
        harness.check(ks, expected);
        ks = AWTKeyStroke.getAWTKeyStroke("alt shift released X");
        expected = AWTKeyStroke.getAWTKeyStroke(88, 576, true);
        harness.check(ks, expected);
        expected = AWTKeyStroke.getAWTKeyStroke(88, 9, true);
        harness.check(ks, expected);
        ks = AWTKeyStroke.getAWTKeyStroke("typed a");
        expected = AWTKeyStroke.getAWTKeyStroke('a');
        harness.check(ks, expected);
        harness.checkPoint("null (String) argument");
        try {
            ks = AWTKeyStroke.getAWTKeyStroke(null);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        catch (Throwable e) {
            harness.check(false);
        }
        harness.checkPoint("bad string");
        try {
            ks = AWTKeyStroke.getAWTKeyStroke("bad");
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }
}

