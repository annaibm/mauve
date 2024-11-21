/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatCodePointException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatCodePointException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new IllegalFormatCodePointException(42);
        }
        catch (IllegalFormatCodePointException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

