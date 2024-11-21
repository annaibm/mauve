/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class compare
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Float.compare(0.0f, 1.0f) < 0);
        harness.check(Float.compare(0.0f, 0.0f) == 0);
        harness.check(Float.compare(1.0f, 0.0f) > 0);
        harness.check(Float.compare(Float.POSITIVE_INFINITY, 0.0f) > 0);
        harness.check(Float.compare(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY) == 0);
        harness.check(Float.compare(0.0f, Float.POSITIVE_INFINITY) < 0);
        harness.check(Float.compare(Float.NEGATIVE_INFINITY, 0.0f) < 0);
        harness.check(Float.compare(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY) == 0);
        harness.check(Float.compare(0.0f, Float.NEGATIVE_INFINITY) > 0);
        harness.check(Float.compare(Float.NaN, 0.0f) > 0);
        harness.check(Float.compare(Float.NaN, Float.NaN) == 0);
        harness.check(Float.compare(0.0f, Float.NaN) < 0);
        harness.check(Float.compare(0.0f, -0.0f) > 0);
        harness.check(Float.compare(-0.0f, 0.0f) < 0);
    }
}

