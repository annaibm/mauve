/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class valueOfDouble
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testRegular(harness);
        this.testInfinities(harness);
        this.testNaN(harness);
    }

    public void testRegular(TestHarness harness) {
        harness.check((Object)1.0, new Double(1.0));
        harness.check((Object)1.0, new Double(1.0));
        harness.check((Object)-1.0, new Double(-1.0));
        harness.check((Object)42.0, new Double(42.0));
        harness.check((Object)0.42, new Double(0.42));
        harness.check((Object)Double.MIN_VALUE, new Double(Double.MIN_VALUE));
        harness.check((Object)Double.MAX_VALUE, new Double(Double.MAX_VALUE));
    }

    public void testInfinities(TestHarness harness) {
        harness.check((Object)Double.POSITIVE_INFINITY, new Double(Double.POSITIVE_INFINITY));
        harness.check((Object)Double.NEGATIVE_INFINITY, new Double(Double.NEGATIVE_INFINITY));
    }

    public void testNaN(TestHarness harness) {
        harness.check((Object)Double.NaN, new Double(Double.NaN));
        harness.check((Object)Double.NaN, new Double(Double.NaN));
        harness.check((Object)Double.NaN, new Double(Double.NaN));
    }
}

