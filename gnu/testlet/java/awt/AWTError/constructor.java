/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.AWTError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTError;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AWTError a = new AWTError("");
        harness.check(a.getMessage(), (Object)"");
        a = new AWTError("awterror");
        harness.check(a.getMessage(), (Object)"awterror");
        try {
            throw new AWTError("");
        }
        catch (Throwable t) {
            harness.check(t.getMessage(), (Object)"");
            harness.check(t instanceof AWTError);
            try {
                throw new AWTError("awterror");
            }
            catch (Throwable t2) {
                harness.check(t2.getMessage(), (Object)"awterror");
                harness.check(t2 instanceof AWTError);
                return;
            }
        }
    }
}

