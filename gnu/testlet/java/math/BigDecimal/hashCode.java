/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class hashCode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.positiveTest(harness);
        this.negativeTest(harness);
    }

    public void positiveTest(TestHarness harness) {
        BigDecimal a = new BigDecimal("0");
        BigDecimal b = new BigDecimal("0");
        harness.check(a.hashCode(), b.hashCode());
        a = BigDecimal.ZERO;
        b = new BigDecimal("0");
        harness.check(a.hashCode(), b.hashCode());
        a = BigDecimal.ZERO;
        b = new BigDecimal(0);
        harness.check(a.hashCode(), b.hashCode());
        a = new BigDecimal("1");
        b = new BigDecimal("1");
        harness.check(a.hashCode(), b.hashCode());
        a = BigDecimal.ONE;
        b = new BigDecimal("1");
        harness.check(a.hashCode(), b.hashCode());
        a = BigDecimal.ONE;
        b = new BigDecimal(1);
        harness.check(a.hashCode(), b.hashCode());
        a = new BigDecimal("0.1");
        b = new BigDecimal("0.1");
        harness.check(a.hashCode(), b.hashCode());
        a = new BigDecimal(10);
        b = BigDecimal.TEN;
        harness.check(a.hashCode(), b.hashCode());
    }

    public void negativeTest(TestHarness harness) {
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.10");
        harness.check(a.hashCode() != b.hashCode());
        a = new BigDecimal("10.0");
        b = BigDecimal.TEN;
        harness.check(a.hashCode() != b.hashCode());
        a = new BigDecimal("10.0");
        b = new BigDecimal("10.00");
        harness.check(a.hashCode() != b.hashCode());
    }
}

