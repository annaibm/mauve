/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class divideRoundingMode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("basic tests");
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("3");
        BigDecimal result = new BigDecimal("4");
        harness.check(a.divide(b, RoundingMode.UP), result);
        result = new BigDecimal("3");
        harness.check(a.divide(b, RoundingMode.DOWN), result);
        result = new BigDecimal("4");
        harness.check(a.divide(b, RoundingMode.CEILING), result);
        result = new BigDecimal("3");
        harness.check(a.divide(b, RoundingMode.FLOOR), result);
        result = new BigDecimal("3");
        harness.check(a.divide(b, RoundingMode.HALF_UP), result);
        result = new BigDecimal("3");
        harness.check(a.divide(b, RoundingMode.HALF_DOWN), result);
        result = new BigDecimal("3");
        harness.check(a.divide(b, RoundingMode.HALF_EVEN), result);
        harness.checkPoint("negative result");
        a = new BigDecimal("10");
        b = new BigDecimal("-3");
        result = new BigDecimal("-4");
        harness.check(a.divide(b, RoundingMode.UP), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, RoundingMode.DOWN), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, RoundingMode.CEILING), result);
        result = new BigDecimal("-4");
        harness.check(a.divide(b, RoundingMode.FLOOR), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, RoundingMode.HALF_UP), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, RoundingMode.HALF_DOWN), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, RoundingMode.HALF_EVEN), result);
        harness.checkPoint("negative result, second test case");
        a = new BigDecimal("-10");
        b = new BigDecimal("3");
        result = new BigDecimal("-4");
        harness.check(a.divide(b, RoundingMode.UP), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, RoundingMode.DOWN), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, RoundingMode.CEILING), result);
        result = new BigDecimal("-4");
        harness.check(a.divide(b, RoundingMode.FLOOR), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, RoundingMode.HALF_UP), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, RoundingMode.HALF_DOWN), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, RoundingMode.HALF_EVEN), result);
    }
}

