/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.IllegalFormatPrecisionException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.IllegalFormatPrecisionException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalFormatPrecisionException object1 = new IllegalFormatPrecisionException(42);
        harness.check(object1 != null);
        harness.check(object1.toString().contains("java.util.IllegalFormatPrecisionException"));
        harness.check(object1.toString().contains("42"));
    }
}

