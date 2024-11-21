/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.FormatFlagsConversionMismatchException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.FormatFlagsConversionMismatchException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FormatFlagsConversionMismatchException object1 = new FormatFlagsConversionMismatchException("nothing happens", 'c');
        harness.check(object1 != null);
        harness.check(object1.toString().contains("java.util.FormatFlagsConversionMismatchException"));
        harness.check(object1.toString().contains("nothing happens"));
    }
}

