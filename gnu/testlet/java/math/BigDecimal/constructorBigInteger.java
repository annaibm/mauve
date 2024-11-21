/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class constructorBigInteger
implements Testlet {
    private static final BigInteger BIGINT_ZERO = BigInteger.ZERO;
    private static final BigInteger BIGINT_ONE = BigInteger.valueOf(1L);
    private static final BigInteger BIGINT_TEN = BigInteger.TEN;
    private static final BigInteger BIGINT_M_ONE = BigInteger.valueOf(-1L);
    private static final BigInteger BIGINT_LONG_VALUE = new BigInteger("123456789000");

    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
        this.test4(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(BigInteger)");
        try {
            harness.check(new BigDecimal(BIGINT_ZERO).toString(), (Object)"0");
            harness.check(new BigDecimal(BIGINT_ONE).toString(), (Object)"1");
            harness.check(new BigDecimal(BIGINT_TEN).toString(), (Object)"10");
            harness.check(new BigDecimal(BIGINT_M_ONE).toString(), (Object)"-1");
            harness.check(new BigDecimal(BIGINT_LONG_VALUE).toString(), (Object)"123456789000");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(BigInteger, MathContext)");
        try {
            harness.check(new BigDecimal(BIGINT_ZERO, MathContext.UNLIMITED).toString(), (Object)"0");
            harness.check(new BigDecimal(BIGINT_ONE, MathContext.UNLIMITED).toString(), (Object)"1");
            harness.check(new BigDecimal(BIGINT_TEN, MathContext.UNLIMITED).toString(), (Object)"10");
            harness.check(new BigDecimal(BIGINT_M_ONE, MathContext.UNLIMITED).toString(), (Object)"-1");
            harness.check(new BigDecimal(BIGINT_LONG_VALUE, MathContext.UNLIMITED).toString(), (Object)"123456789000");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }

    public void test3(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(BigInteger, scale)");
        try {
            harness.check(new BigDecimal(BIGINT_ONE, 0).toString(), (Object)"1");
            harness.check(new BigDecimal(BIGINT_ONE, 1).toString(), (Object)"0.1");
            harness.check(new BigDecimal(BIGINT_ONE, 4).toString(), (Object)"0.0001");
            harness.check(new BigDecimal(BIGINT_ONE, 10).toString(), (Object)"1E-10");
            harness.check(new BigDecimal(BIGINT_ONE, -1).toString(), (Object)"1E+1");
            harness.check(new BigDecimal(BIGINT_ONE, -2).toString(), (Object)"1E+2");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }

    public void test4(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(BigInteger, scale, MathContext)");
        try {
            harness.check(new BigDecimal(BIGINT_ONE, 0, MathContext.UNLIMITED).toString(), (Object)"1");
            harness.check(new BigDecimal(BIGINT_ONE, 1, MathContext.UNLIMITED).toString(), (Object)"0.1");
            harness.check(new BigDecimal(BIGINT_ONE, 4, MathContext.UNLIMITED).toString(), (Object)"0.0001");
            harness.check(new BigDecimal(BIGINT_ONE, 10, MathContext.UNLIMITED).toString(), (Object)"1E-10");
            harness.check(new BigDecimal(BIGINT_ONE, -1, MathContext.UNLIMITED).toString(), (Object)"1E+1");
            harness.check(new BigDecimal(BIGINT_ONE, -2, MathContext.UNLIMITED).toString(), (Object)"1E+2");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }
}

