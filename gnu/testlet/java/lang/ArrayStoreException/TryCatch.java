/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ArrayStoreException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new ArrayStoreException("ArrayStoreException");
        }
        catch (ArrayStoreException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

