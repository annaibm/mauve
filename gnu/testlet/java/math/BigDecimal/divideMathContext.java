/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;
import java.math.MathContext;

public class divideMathContext
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BigDecimal a;
        BigDecimal b = a = new BigDecimal("0");
        harness.checkPoint("basic tests");
        a = new BigDecimal("10");
        b = new BigDecimal("2");
        BigDecimal result = new BigDecimal("5");
        harness.check(a.divide(b, new MathContext(0)), result);
        a = a.negate();
        b = b.negate();
        result = new BigDecimal("5");
        harness.check(a.divide(b, new MathContext(0)), result);
        b = b.negate();
        result = new BigDecimal("-5");
        harness.check(a.divide(b, new MathContext(0)), result);
        harness.checkPoint("rounding to one");
        a = new BigDecimal("1000000000000000000");
        b = new BigDecimal("1000000000000000000");
        result = new BigDecimal("1");
        harness.check(a.divide(b, new MathContext(0)), result);
        a = a.negate();
        b = b.negate();
        result = new BigDecimal("1");
        harness.check(a.divide(b, new MathContext(0)), result);
        b = b.negate();
        result = new BigDecimal("-1");
        harness.check(a.divide(b, new MathContext(0)), result);
        harness.checkPoint("rounding to zero");
        a = new BigDecimal("10");
        b = new BigDecimal("20");
        result = new BigDecimal("0.5");
        harness.check(a.divide(b, new MathContext(0)), result);
        a = a.negate();
        b = b.negate();
        result = new BigDecimal("0.5");
        harness.check(a.divide(b, new MathContext(0)), result);
        b = b.negate();
        result = new BigDecimal("-0.5");
        harness.check(a.divide(b, new MathContext(0)), result);
        harness.checkPoint("rounding with division");
        a = new BigDecimal("20.9");
        b = new BigDecimal("10.1");
        result = new BigDecimal("2");
        try {
            a.divide(b, new MathContext(0));
            harness.fail("ArithmeticException not thrown as expected");
        }
        catch (ArithmeticException arithmeticException) {
            // empty catch block
        }
        harness.checkPoint("rounding with division ");
        a = new BigDecimal("20.1");
        b = new BigDecimal("10.9");
        result = new BigDecimal("2");
        try {
            a.divide(b, new MathContext(0));
            harness.fail("ArithmeticException not thrown as expected");
        }
        catch (ArithmeticException arithmeticException) {
            // empty catch block
        }
        harness.checkPoint("rounding with division ");
        a = new BigDecimal("20.000000000000000000001");
        b = new BigDecimal("10.000000000000000000001");
        result = new BigDecimal("2");
        try {
            a.divide(b, new MathContext(0));
            harness.fail("ArithmeticException not thrown as expected");
        }
        catch (ArithmeticException arithmeticException) {
            // empty catch block
        }
    }
}

