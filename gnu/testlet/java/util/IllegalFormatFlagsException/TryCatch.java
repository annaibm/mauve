/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatFlagsException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatFlagsException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new IllegalFormatFlagsException("IllegalFormatFlagsException");
        }
        catch (IllegalFormatFlagsException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

