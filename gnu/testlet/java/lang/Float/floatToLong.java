/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class floatToLong
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testZero(harness);
        this.testPositiveValue(harness);
        this.testNegativeValue(harness);
        this.testNaN(harness);
        this.testPositiveInfinity(harness);
        this.testNegativeInfinity(harness);
    }

    public void testZero(TestHarness harness) {
        float value2 = 0.0f;
        boolean result = (long)value2 == 0L;
        harness.check(result);
    }

    public void testPositiveValue(TestHarness harness) {
        float value2 = 123.456f;
        boolean result = (long)value2 == 123L;
        harness.check(result);
        value2 = 456.789f;
        result = (long)value2 == 456L;
        harness.check(result);
    }

    public void testNegativeValue(TestHarness harness) {
        float value2 = -123.456f;
        boolean result = (long)value2 == -123L;
        harness.check(result);
        value2 = -456.789f;
        result = (long)value2 == -456L;
        harness.check(result);
    }

    public void testNaN(TestHarness harness) {
        float value2 = Float.NaN;
        boolean result = (long)value2 == 0L;
        harness.check(result);
    }

    public void testPositiveInfinity(TestHarness harness) {
        float value2 = Float.POSITIVE_INFINITY;
        boolean result = (long)value2 == Long.MAX_VALUE;
        harness.check(result);
    }

    public void testNegativeInfinity(TestHarness harness) {
        float value2 = Float.NEGATIVE_INFINITY;
        boolean result = (long)value2 == Long.MIN_VALUE;
        harness.check(result);
    }
}

