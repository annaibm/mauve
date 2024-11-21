/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class doubleToLongBits
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(0L, Double.doubleToLongBits(0.0));
        harness.check(0x3FF0000000000000L, Double.doubleToLongBits(1.0));
        harness.check(0x4000000000000000L, Double.doubleToLongBits(2.0));
        harness.check(4652007308841189376L, Double.doubleToLongBits(1000.0));
        harness.check(-4616189618054758400L, Double.doubleToLongBits(-1.0));
        harness.check(-4611686018427387904L, Double.doubleToLongBits(-2.0));
        harness.check(-4571364728013586432L, Double.doubleToLongBits(-1000.0));
        harness.check(0x7FF0000000000000L, Double.doubleToLongBits(Double.POSITIVE_INFINITY));
        harness.check(-4503599627370496L, Double.doubleToLongBits(Double.NEGATIVE_INFINITY));
        harness.check(0x7FEFFFFFFFFFFFFFL, Double.doubleToLongBits(Double.MAX_VALUE));
        harness.check(1L, Double.doubleToLongBits(Double.MIN_VALUE));
        harness.check(-4503599627370497L, Double.doubleToLongBits(-1.7976931348623157E308));
        harness.check(-9223372036854775807L, Double.doubleToLongBits(-4.9E-324));
        harness.check(9221120237041090560L, Double.doubleToLongBits(Double.NaN));
    }
}

