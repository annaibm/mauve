/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.SyncFailedException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.SyncFailedException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new SyncFailedException("SyncFailedException");
        }
        catch (SyncFailedException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

