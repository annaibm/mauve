/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InvalidClassException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InvalidClassException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new InvalidClassException("InvalidClassException");
        }
        catch (InvalidClassException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

