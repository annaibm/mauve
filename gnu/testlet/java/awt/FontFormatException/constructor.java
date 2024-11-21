/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.FontFormatException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.FontFormatException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FontFormatException a = new FontFormatException("");
        harness.check(a.getMessage(), (Object)"");
        a = new FontFormatException("FontFormatException");
        harness.check(a.getMessage(), (Object)"FontFormatException");
        try {
            throw new FontFormatException("");
        }
        catch (Throwable t) {
            harness.check(t.getMessage(), (Object)"");
            harness.check(t instanceof FontFormatException);
            try {
                throw new FontFormatException("FontFormatException");
            }
            catch (Throwable t2) {
                harness.check(t2.getMessage(), (Object)"FontFormatException");
                harness.check(t2 instanceof FontFormatException);
                return;
            }
        }
    }
}

