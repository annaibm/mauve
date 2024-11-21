/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoSuchMethodException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new NoSuchMethodException("NoSuchMethodException");
        }
        catch (NoSuchMethodException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

