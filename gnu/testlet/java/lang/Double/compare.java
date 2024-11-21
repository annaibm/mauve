/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class compare
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Double.compare(0.0, 1.0) < 0);
        harness.check(Double.compare(0.0, 0.0) == 0);
        harness.check(Double.compare(1.0, 0.0) > 0);
        harness.check(Double.compare(Double.POSITIVE_INFINITY, 0.0) > 0);
        harness.check(Double.compare(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY) == 0);
        harness.check(Double.compare(0.0, Double.POSITIVE_INFINITY) < 0);
        harness.check(Double.compare(Double.NEGATIVE_INFINITY, 0.0) < 0);
        harness.check(Double.compare(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY) == 0);
        harness.check(Double.compare(0.0, Double.NEGATIVE_INFINITY) > 0);
        harness.check(Double.compare(Double.NaN, 0.0) > 0);
        harness.check(Double.compare(Double.NaN, Double.NaN) == 0);
        harness.check(Double.compare(0.0, Double.NaN) < 0);
        harness.check(Double.compare(0.0, -0.0) > 0);
        harness.check(Double.compare(-0.0, 0.0) < 0);
    }
}

