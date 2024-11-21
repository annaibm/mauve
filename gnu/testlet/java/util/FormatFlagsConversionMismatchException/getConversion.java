/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.FormatFlagsConversionMismatchException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.FormatFlagsConversionMismatchException;

public class getConversion
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FormatFlagsConversionMismatchException object1 = new FormatFlagsConversionMismatchException("", 'c');
        harness.check(object1 != null);
        harness.check(object1.getConversion() == 'c');
        FormatFlagsConversionMismatchException object2 = new FormatFlagsConversionMismatchException("nothing happens", 'c');
        harness.check(object2 != null);
        harness.check(object2.getConversion() == 'c');
        FormatFlagsConversionMismatchException object3 = new FormatFlagsConversionMismatchException("nothing happens", ' ');
        harness.check(object3 != null);
        harness.check(object3.getConversion() == ' ');
        FormatFlagsConversionMismatchException object4 = new FormatFlagsConversionMismatchException("nothing happens", '\u1234');
        harness.check(object4 != null);
        harness.check(object4.getConversion() == '\u1234');
    }
}

