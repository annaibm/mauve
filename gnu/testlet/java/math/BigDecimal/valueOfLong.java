/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class valueOfLong
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new BigDecimal("0"), BigDecimal.valueOf(0L));
        harness.check(new BigDecimal("1"), BigDecimal.valueOf(1L));
        harness.check(new BigDecimal("9223372036854775807"), BigDecimal.valueOf(Long.MAX_VALUE));
        harness.check(new BigDecimal("-9223372036854775808"), BigDecimal.valueOf(Long.MIN_VALUE));
    }
}

