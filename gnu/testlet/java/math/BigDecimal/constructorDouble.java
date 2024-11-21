/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;
import java.math.MathContext;

public class constructorDouble
implements Testlet {
    private static final double DOUBLE_VALUE_1 = 0.0;
    private static final double DOUBLE_VALUE_2 = -0.0;
    private static final double DOUBLE_VALUE_3 = 10.0;
    private static final double DOUBLE_VALUE_4 = -10.0;
    private static final double DOUBLE_VALUE_5 = 1.0E10;
    private static final double DOUBLE_VALUE_6 = -1.0E10;
    private static final double DOUBLE_VALUE_NAN = Double.NaN;

    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(double)");
        try {
            harness.check(new BigDecimal(0.0).toString(), (Object)"0");
            harness.check(new BigDecimal(-0.0).toString(), (Object)"0");
            harness.check(new BigDecimal(10.0).toString(), (Object)"10");
            harness.check(new BigDecimal(-10.0).toString(), (Object)"-10");
            harness.check(new BigDecimal(1.0E10).toString(), (Object)"10000000000");
            harness.check(new BigDecimal(-1.0E10).toString(), (Object)"-10000000000");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
        try {
            harness.check(new BigDecimal(Double.NaN).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(double, MathContext)");
        try {
            harness.check(new BigDecimal(0.0, MathContext.UNLIMITED).toString(), (Object)"0");
            harness.check(new BigDecimal(-0.0, MathContext.UNLIMITED).toString(), (Object)"0");
            harness.check(new BigDecimal(10.0, MathContext.UNLIMITED).toString(), (Object)"10");
            harness.check(new BigDecimal(-10.0, MathContext.UNLIMITED).toString(), (Object)"-10");
            harness.check(new BigDecimal(1.0E10, MathContext.UNLIMITED).toString(), (Object)"10000000000");
            harness.check(new BigDecimal(-1.0E10, MathContext.UNLIMITED).toString(), (Object)"-10000000000");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
        try {
            harness.check(new BigDecimal(Double.NaN, MathContext.UNLIMITED).toString(), (Object)"");
            harness.fail("NumberFormatException not thrown as expected");
        }
        catch (NumberFormatException numberFormatException) {
            // empty catch block
        }
    }
}

