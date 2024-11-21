/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.IllegalComponentStateException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.IllegalComponentStateException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalComponentStateException a = new IllegalComponentStateException("");
        harness.check(a.getMessage(), (Object)"");
        a = new IllegalComponentStateException("IllegalComponentStateException");
        harness.check(a.getMessage(), (Object)"IllegalComponentStateException");
        try {
            throw new IllegalComponentStateException("");
        }
        catch (Throwable t) {
            harness.check(t.getMessage(), (Object)"");
            harness.check(t instanceof IllegalComponentStateException);
            try {
                throw new IllegalComponentStateException("IllegalComponentStateException");
            }
            catch (Throwable t2) {
                harness.check(t2.getMessage(), (Object)"IllegalComponentStateException");
                harness.check(t2 instanceof IllegalComponentStateException);
                return;
            }
        }
    }
}

