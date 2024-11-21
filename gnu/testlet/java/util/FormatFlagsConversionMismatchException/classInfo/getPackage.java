/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.FormatFlagsConversionMismatchException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.FormatFlagsConversionMismatchException;

public class getPackage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FormatFlagsConversionMismatchException o = new FormatFlagsConversionMismatchException("FormatFlagsConversionMismatchException", 'c');
        Class<?> c = o.getClass();
        Package p = c.getPackage();
        harness.check(p.getName(), (Object)"java.util");
    }
}

