/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.ConcurrentModificationException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ConcurrentModificationException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new ConcurrentModificationException("ConcurrentModificationException");
        }
        catch (ConcurrentModificationException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

