/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ExceptionInInitializerError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getCause
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new ExceptionInInitializerError("ExceptionInInitializerError");
        }
        catch (ExceptionInInitializerError e) {
            caught = true;
            Throwable t = e.getCause();
            harness.check(t, null);
            harness.check(caught);
            return;
        }
    }
}

