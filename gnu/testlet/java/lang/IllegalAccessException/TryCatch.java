/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalAccessException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new IllegalAccessException("IllegalAccessException");
        }
        catch (IllegalAccessException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

