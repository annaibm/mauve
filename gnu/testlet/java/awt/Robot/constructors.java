/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Robot;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTException;
import java.awt.Robot;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            Robot robot = new Robot();
        }
        catch (AWTException e) {
            harness.fail("caught AWT exception: " + e.getMessage());
        }
        harness.check(true);
    }
}

