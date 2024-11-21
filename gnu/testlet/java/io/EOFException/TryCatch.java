/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.EOFException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.EOFException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new EOFException("EOFException");
        }
        catch (EOFException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

