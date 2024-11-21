/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.AWTException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AWTException a = new AWTException("");
        harness.check(a.getMessage(), (Object)"");
        a = new AWTException("AWTException");
        harness.check(a.getMessage(), (Object)"AWTException");
        try {
            throw new AWTException("");
        }
        catch (Throwable t) {
            harness.check(t.getMessage(), (Object)"");
            harness.check(t instanceof AWTException);
            try {
                throw new AWTException("AWTException");
            }
            catch (Throwable t2) {
                harness.check(t2.getMessage(), (Object)"AWTException");
                harness.check(t2 instanceof AWTException);
                return;
            }
        }
    }
}

