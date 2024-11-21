/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnknownError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new UnknownError("UnknownError");
        }
        catch (UnknownError e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

