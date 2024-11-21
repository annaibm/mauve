/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class floatToInt
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
        boolean result = (int)value2 == 0;
        harness.check(result);
    }

    public void testPositiveValue(TestHarness harness) {
        float value2 = 123.456f;
        boolean result = (int)value2 == 123;
        harness.check(result);
        value2 = 456.789f;
        result = (int)value2 == 456;
        harness.check(result);
    }

    public void testNegativeValue(TestHarness harness) {
        float value2 = -123.456f;
        boolean result = (int)value2 == -123;
        harness.check(result);
        value2 = -456.789f;
        result = (int)value2 == -456;
        harness.check(result);
    }

    public void testNaN(TestHarness harness) {
        float value2 = Float.NaN;
        boolean result = (int)value2 == 0;
        harness.check(result);
    }

    public void testPositiveInfinity(TestHarness harness) {
        float value2 = Float.POSITIVE_INFINITY;
        boolean result = (int)value2 == Integer.MAX_VALUE;
        harness.check(result);
    }

    public void testNegativeInfinity(TestHarness harness) {
        float value2 = Float.NEGATIVE_INFINITY;
        boolean result = (int)value2 == Integer.MIN_VALUE;
        harness.check(result);
    }
}

