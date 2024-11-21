/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.FormatFlagsConversionMismatchException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.FormatFlagsConversionMismatchException;

public class getMessage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FormatFlagsConversionMismatchException object1 = new FormatFlagsConversionMismatchException("", 'c');
        harness.check(object1 != null);
        harness.check(object1.getMessage() != null);
        harness.check(object1.getMessage().contains("Flags ="));
        harness.check(object1.getMessage().contains("Conversion ="));
        FormatFlagsConversionMismatchException object2 = new FormatFlagsConversionMismatchException("nothing happens", 'c');
        harness.check(object2 != null);
        harness.check(object2.getMessage() != null);
        harness.check(object2.getMessage().contains("nothing happens"));
        harness.check(object2.getMessage().contains("Flags ="));
        harness.check(object2.getMessage().contains("Conversion ="));
        FormatFlagsConversionMismatchException object3 = new FormatFlagsConversionMismatchException("", '@');
        harness.check(object3 != null);
        harness.check(object3.getMessage() != null);
        harness.check(object3.getMessage().contains("@"));
        FormatFlagsConversionMismatchException object4 = new FormatFlagsConversionMismatchException("nothing happens", '@');
        harness.check(object4 != null);
        harness.check(object4.getMessage() != null);
        harness.check(object4.getMessage().contains("@"));
    }
}

