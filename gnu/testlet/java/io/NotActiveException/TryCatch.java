/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.NotActiveException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.NotActiveException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new NotActiveException("NotActiveException");
        }
        catch (NotActiveException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

