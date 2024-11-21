/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.FormatFlagsConversionMismatchException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.FormatFlagsConversionMismatchException;

public class isInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FormatFlagsConversionMismatchException o = new FormatFlagsConversionMismatchException("FormatFlagsConversionMismatchException", 'c');
        Class<?> c = o.getClass();
        harness.check(c.isInstance(new FormatFlagsConversionMismatchException("FormatFlagsConversionMismatchException", 'c')));
    }
}

