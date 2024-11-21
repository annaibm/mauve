/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class precision
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new BigDecimal(0).precision(), 1);
        harness.check(BigDecimal.ZERO.precision(), 1);
        harness.check(BigDecimal.ONE.precision(), 1);
        harness.check(BigDecimal.TEN.precision(), 2);
        harness.check(new BigDecimal("1").precision(), 1);
        harness.check(new BigDecimal("1.").precision(), 1);
        harness.check(new BigDecimal("0.1").precision(), 1);
        harness.check(new BigDecimal(".1").precision(), 1);
        harness.check(new BigDecimal("10").precision(), 2);
        harness.check(new BigDecimal("100").precision(), 3);
        harness.check(new BigDecimal("1000").precision(), 4);
        harness.check(new BigDecimal("0.001").precision(), 1);
        harness.check(new BigDecimal(".001").precision(), 1);
        harness.check(new BigDecimal("1.1").precision(), 2);
        harness.check(new BigDecimal("1.01").precision(), 3);
        harness.check(new BigDecimal("1.001").precision(), 4);
        harness.check(new BigDecimal("10.001").precision(), 5);
        harness.check(new BigDecimal("100.001").precision(), 6);
    }
}

