/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.IOError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOError;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new IOError(new Throwable("e"));
        }
        catch (IOError e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

