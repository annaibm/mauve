/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InterruptedIOException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InterruptedIOException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new InterruptedIOException("InterruptedIOException");
        }
        catch (InterruptedIOException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

