/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class valueOfLongInt
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new BigDecimal("0"), BigDecimal.valueOf(0L, 0));
        harness.check(new BigDecimal("1"), BigDecimal.valueOf(1L, 0));
        harness.check(new BigDecimal("9223372036854775807"), BigDecimal.valueOf(Long.MAX_VALUE, 0));
        harness.check(new BigDecimal("-9223372036854775808"), BigDecimal.valueOf(Long.MIN_VALUE, 0));
        harness.check(new BigDecimal("0.0"), BigDecimal.valueOf(0L, 1));
        harness.check(new BigDecimal("0.1"), BigDecimal.valueOf(1L, 1));
        harness.check(new BigDecimal("922337203685477580.7"), BigDecimal.valueOf(Long.MAX_VALUE, 1));
        harness.check(new BigDecimal("-922337203685477580.8"), BigDecimal.valueOf(Long.MIN_VALUE, 1));
        harness.check(new BigDecimal("0.00"), BigDecimal.valueOf(0L, 2));
        harness.check(new BigDecimal("0.01"), BigDecimal.valueOf(1L, 2));
        harness.check(new BigDecimal("92233720368547758.07"), BigDecimal.valueOf(Long.MAX_VALUE, 2));
        harness.check(new BigDecimal("-92233720368547758.08"), BigDecimal.valueOf(Long.MIN_VALUE, 2));
    }
}

