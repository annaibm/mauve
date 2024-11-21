/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.DuplicateFormatFlagsException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.DuplicateFormatFlagsException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new DuplicateFormatFlagsException("DuplicateFormatFlagsException");
        }
        catch (DuplicateFormatFlagsException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

