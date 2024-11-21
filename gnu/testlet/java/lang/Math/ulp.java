/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class ulp
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Math.ulp(0.0), Double.MIN_VALUE);
        harness.check(Math.ulp(Double.NaN), Double.NaN);
        harness.check(Math.ulp(Double.MAX_VALUE), Math.pow(2.0, 971.0));
        harness.check(Math.ulp(Double.NEGATIVE_INFINITY), Double.POSITIVE_INFINITY);
        harness.check(Math.ulp(Double.MIN_VALUE), Double.MIN_VALUE);
        harness.check(Math.ulp(0.0f), 1.4E-45f);
        harness.check(Math.ulp(Float.NaN), Double.NaN);
        harness.check(Math.ulp(Float.MAX_VALUE), Math.pow(2.0, 104.0));
        harness.check(Math.ulp(Float.NEGATIVE_INFINITY), Double.POSITIVE_INFINITY);
        harness.check(Math.ulp(Float.MIN_VALUE), 1.4E-45f);
    }
}

