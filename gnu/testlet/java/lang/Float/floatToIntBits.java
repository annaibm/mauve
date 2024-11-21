/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class floatToIntBits
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(0, Float.floatToIntBits(0.0f));
        harness.check(1065353216, Float.floatToIntBits(1.0f));
        harness.check(0x40000000, Float.floatToIntBits(2.0f));
        harness.check(1148846080, Float.floatToIntBits(1000.0f));
        harness.check(-1082130432, Float.floatToIntBits(-1.0f));
        harness.check(-1073741824, Float.floatToIntBits(-2.0f));
        harness.check(-998637568, Float.floatToIntBits(-1000.0f));
        harness.check(2139095040, Float.floatToIntBits(Float.POSITIVE_INFINITY));
        harness.check(-8388608, Float.floatToIntBits(Float.NEGATIVE_INFINITY));
        harness.check(0x7F7FFFFF, Float.floatToIntBits(Float.MAX_VALUE));
        harness.check(1, Float.floatToIntBits(Float.MIN_VALUE));
        harness.check(-8388609, Float.floatToIntBits(-3.4028235E38f));
        harness.check(-2147483647, Float.floatToIntBits(-1.4E-45f));
        harness.check(2143289344, Float.floatToIntBits(Float.NaN));
    }
}

