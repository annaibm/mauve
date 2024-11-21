/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class valueOfDouble
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new BigDecimal("0.0"), BigDecimal.valueOf(0.0));
        harness.check(new BigDecimal("1.0"), BigDecimal.valueOf(1.0));
        harness.check(new BigDecimal("0.0"), BigDecimal.valueOf(0.0));
        harness.check(new BigDecimal("0.0"), BigDecimal.valueOf(0.0));
        harness.check(new BigDecimal("1.0"), BigDecimal.valueOf(1.0));
        harness.check(new BigDecimal("1.7976931348623157E+308"), BigDecimal.valueOf(Double.MAX_VALUE));
        harness.check(new BigDecimal("4.9E-324"), BigDecimal.valueOf(Double.MIN_VALUE));
        try {
            BigDecimal.valueOf(Double.NaN);
            harness.fail("Exception don't thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }
}

