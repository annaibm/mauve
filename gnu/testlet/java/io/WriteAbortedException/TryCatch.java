/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.WriteAbortedException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.WriteAbortedException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new WriteAbortedException("WriteAbortedException", new Exception("e"));
        }
        catch (WriteAbortedException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

