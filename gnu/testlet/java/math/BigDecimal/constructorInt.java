/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;
import java.math.MathContext;

public class constructorInt
implements Testlet {
    private static final int INT_VALUE_1 = 0;
    private static final int INT_VALUE_2 = 0;
    private static final int INT_VALUE_3 = 1;
    private static final int INT_VALUE_4 = -1;
    private static final int INT_VALUE_5 = Integer.MAX_VALUE;
    private static final int INT_VALUE_6 = Integer.MIN_VALUE;

    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(int)");
        try {
            harness.check(new BigDecimal(0).toString(), (Object)"0");
            harness.check(new BigDecimal(0).toString(), (Object)"0");
            harness.check(new BigDecimal(1).toString(), (Object)"1");
            harness.check(new BigDecimal(-1).toString(), (Object)"-1");
            harness.check(new BigDecimal(Integer.MAX_VALUE).toString(), (Object)"2147483647");
            harness.check(new BigDecimal(Integer.MIN_VALUE).toString(), (Object)"-2147483648");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(int, MathContext)");
        try {
            harness.check(new BigDecimal(0, MathContext.UNLIMITED).toString(), (Object)"0");
            harness.check(new BigDecimal(0, MathContext.UNLIMITED).toString(), (Object)"0");
            harness.check(new BigDecimal(1, MathContext.UNLIMITED).toString(), (Object)"1");
            harness.check(new BigDecimal(-1, MathContext.UNLIMITED).toString(), (Object)"-1");
            harness.check(new BigDecimal(Integer.MAX_VALUE, MathContext.UNLIMITED).toString(), (Object)"2147483647");
            harness.check(new BigDecimal(Integer.MIN_VALUE, MathContext.UNLIMITED).toString(), (Object)"-2147483648");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }
}

