/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatConversionException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatConversionException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatConversionException object1 = new IllegalFormatConversionException('c', Integer.class);
        harness.check(object1 != null);
        harness.check(object1.toString().contains("java.util.IllegalFormatConversionException"));
        harness.check(object1.toString().contains("Integer"));
    }
}

