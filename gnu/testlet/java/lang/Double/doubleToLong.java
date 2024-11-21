/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class doubleToLong
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
        double value2 = 0.0;
        boolean result = (long)value2 == 0L;
        harness.check(result);
    }

    public void testPositiveValue(TestHarness harness) {
        double value2 = 123.456;
        boolean result = (long)value2 == 123L;
        harness.check(result);
        value2 = 456.789;
        result = (long)value2 == 456L;
        harness.check(result);
    }

    public void testNegativeValue(TestHarness harness) {
        double value2 = -123.456;
        boolean result = (long)value2 == -123L;
        harness.check(result);
        value2 = -456.789;
        result = (long)value2 == -456L;
        harness.check(result);
    }

    public void testNaN(TestHarness harness) {
        double value2 = Double.NaN;
        boolean result = (long)value2 == 0L;
        harness.check(result);
    }

    public void testPositiveInfinity(TestHarness harness) {
        double value2 = Double.POSITIVE_INFINITY;
        boolean result = (long)value2 == Long.MAX_VALUE;
        harness.check(result);
    }

    public void testNegativeInfinity(TestHarness harness) {
        double value2 = Double.NEGATIVE_INFINITY;
        boolean result = (long)value2 == Long.MIN_VALUE;
        harness.check(result);
    }
}

