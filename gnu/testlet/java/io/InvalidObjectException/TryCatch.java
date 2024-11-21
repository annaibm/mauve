/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InvalidObjectException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InvalidObjectException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new InvalidObjectException("InvalidObjectException");
        }
        catch (InvalidObjectException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

