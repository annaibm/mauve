/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalArgumentException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

