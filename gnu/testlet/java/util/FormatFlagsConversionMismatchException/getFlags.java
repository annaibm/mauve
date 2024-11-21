/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.FormatFlagsConversionMismatchException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.FormatFlagsConversionMismatchException;

public class getFlags
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FormatFlagsConversionMismatchException object1 = new FormatFlagsConversionMismatchException("", 'c');
        harness.check(object1 != null);
        harness.check(object1.getFlags() != null);
        harness.check(object1.getFlags().isEmpty());
        FormatFlagsConversionMismatchException object2 = new FormatFlagsConversionMismatchException("nothing happens", 'c');
        harness.check(object2 != null);
        harness.check(object2.getFlags() != null);
        harness.check(object2.getFlags().contains("nothing happens"));
    }
}

