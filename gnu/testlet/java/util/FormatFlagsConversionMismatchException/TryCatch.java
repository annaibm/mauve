/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.FormatFlagsConversionMismatchException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.FormatFlagsConversionMismatchException;

public class TryCatch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        boolean caught = false;
        try {
            throw new FormatFlagsConversionMismatchException("FormatFlagsConversionMismatchException", 'c');
        }
        catch (FormatFlagsConversionMismatchException e) {
            caught = true;
            harness.check(caught);
            return;
        }
    }
}

