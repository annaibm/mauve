/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;
import java.math.MathContext;

public class constructorLong
implements Testlet {
    private static final long LONG_VALUE_1 = 0L;
    private static final long LONG_VALUE_2 = 0L;
    private static final long LONG_VALUE_3 = 1L;
    private static final long LONG_VALUE_4 = -1L;
    private static final long LONG_VALUE_5 = Long.MAX_VALUE;
    private static final long LONG_VALUE_6 = Long.MIN_VALUE;

    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(long)");
        try {
            harness.check(new BigDecimal(0L).toString(), (Object)"0");
            harness.check(new BigDecimal(0L).toString(), (Object)"0");
            harness.check(new BigDecimal(1L).toString(), (Object)"1");
            harness.check(new BigDecimal(-1L).toString(), (Object)"-1");
            harness.check(new BigDecimal(Long.MAX_VALUE).toString(), (Object)"9223372036854775807");
            harness.check(new BigDecimal(Long.MIN_VALUE).toString(), (Object)"-9223372036854775808");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(long, MathContext)");
        try {
            harness.check(new BigDecimal(0L, MathContext.UNLIMITED).toString(), (Object)"0");
            harness.check(new BigDecimal(0L, MathContext.UNLIMITED).toString(), (Object)"0");
            harness.check(new BigDecimal(1L, MathContext.UNLIMITED).toString(), (Object)"1");
            harness.check(new BigDecimal(-1L, MathContext.UNLIMITED).toString(), (Object)"-1");
            harness.check(new BigDecimal(Long.MAX_VALUE, MathContext.UNLIMITED).toString(), (Object)"9223372036854775807");
            harness.check(new BigDecimal(Long.MIN_VALUE, MathContext.UNLIMITED).toString(), (Object)"-9223372036854775808");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }
}

