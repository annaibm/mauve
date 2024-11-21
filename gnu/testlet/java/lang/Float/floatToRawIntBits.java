/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class floatToRawIntBits
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(0, Float.floatToRawIntBits(0.0f));
        harness.check(1065353216, Float.floatToRawIntBits(1.0f));
        harness.check(0x40000000, Float.floatToRawIntBits(2.0f));
        harness.check(1148846080, Float.floatToRawIntBits(1000.0f));
        harness.check(-1082130432, Float.floatToRawIntBits(-1.0f));
        harness.check(-1073741824, Float.floatToRawIntBits(-2.0f));
        harness.check(-998637568, Float.floatToRawIntBits(-1000.0f));
        harness.check(2139095040, Float.floatToRawIntBits(Float.POSITIVE_INFINITY));
        harness.check(-8388608, Float.floatToRawIntBits(Float.NEGATIVE_INFINITY));
        harness.check(0x7F7FFFFF, Float.floatToRawIntBits(Float.MAX_VALUE));
        harness.check(1, Float.floatToRawIntBits(Float.MIN_VALUE));
        harness.check(-8388609, Float.floatToRawIntBits(-3.4028235E38f));
        harness.check(-2147483647, Float.floatToRawIntBits(-1.4E-45f));
        harness.check(2143289344, Float.floatToRawIntBits(Float.NaN));
    }
}

