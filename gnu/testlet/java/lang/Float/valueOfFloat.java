/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class valueOfFloat
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testRegular(harness);
        this.testInfinities(harness);
        this.testNaN(harness);
    }

    public void testRegular(TestHarness harness) {
        harness.check(Float.valueOf(1.0f), new Float(1.0));
        harness.check(Float.valueOf(1.0f), new Float(1.0));
        harness.check(Float.valueOf(-1.0f), new Float(-1.0));
        harness.check(Float.valueOf(42.0f), new Float(42.0));
        harness.check(Float.valueOf(0.42f), new Float(0.42));
        harness.check(Float.valueOf(Float.MIN_VALUE), new Float(Float.MIN_VALUE));
        harness.check(Float.valueOf(Float.MAX_VALUE), new Float(Float.MAX_VALUE));
    }

    public void testInfinities(TestHarness harness) {
        harness.check(Float.valueOf(Float.POSITIVE_INFINITY), new Float(Float.POSITIVE_INFINITY));
        harness.check(Float.valueOf(Float.NEGATIVE_INFINITY), new Float(Float.NEGATIVE_INFINITY));
    }

    public void testNaN(TestHarness harness) {
        harness.check(Float.valueOf(Float.NaN), new Float(Float.NaN));
        harness.check(Float.valueOf(Float.NaN), new Float(Float.NaN));
        harness.check(Float.valueOf(Float.NaN), new Float(Float.NaN));
    }
}

