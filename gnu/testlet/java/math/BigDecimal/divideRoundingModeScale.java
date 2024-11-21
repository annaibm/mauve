/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class divideRoundingModeScale
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("basic tests, scale=0");
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal("3");
        BigDecimal result = new BigDecimal("4");
        harness.check(a.divide(b, 0, RoundingMode.UP), result);
        result = new BigDecimal("3");
        harness.check(a.divide(b, 0, RoundingMode.DOWN), result);
        result = new BigDecimal("4");
        harness.check(a.divide(b, 0, RoundingMode.CEILING), result);
        result = new BigDecimal("3");
        harness.check(a.divide(b, 0, RoundingMode.FLOOR), result);
        result = new BigDecimal("3");
        harness.check(a.divide(b, 0, RoundingMode.HALF_UP), result);
        result = new BigDecimal("3");
        harness.check(a.divide(b, 0, RoundingMode.HALF_DOWN), result);
        result = new BigDecimal("3");
        harness.check(a.divide(b, 0, RoundingMode.HALF_EVEN), result);
        harness.checkPoint("negative result, scale=0");
        a = new BigDecimal("10");
        b = new BigDecimal("-3");
        result = new BigDecimal("-4");
        harness.check(a.divide(b, 0, RoundingMode.UP), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, 0, RoundingMode.DOWN), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, 0, RoundingMode.CEILING), result);
        result = new BigDecimal("-4");
        harness.check(a.divide(b, 0, RoundingMode.FLOOR), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, 0, RoundingMode.HALF_UP), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, 0, RoundingMode.HALF_DOWN), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, 0, RoundingMode.HALF_EVEN), result);
        harness.checkPoint("negative result, second test case, scale=0");
        a = new BigDecimal("-10");
        b = new BigDecimal("3");
        result = new BigDecimal("-4");
        harness.check(a.divide(b, 0, RoundingMode.UP), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, 0, RoundingMode.DOWN), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, 0, RoundingMode.CEILING), result);
        result = new BigDecimal("-4");
        harness.check(a.divide(b, 0, RoundingMode.FLOOR), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, 0, RoundingMode.HALF_UP), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, 0, RoundingMode.HALF_DOWN), result);
        result = new BigDecimal("-3");
        harness.check(a.divide(b, 0, RoundingMode.HALF_EVEN), result);
        harness.checkPoint("basic tests, scale=2");
        a = new BigDecimal("10");
        b = new BigDecimal("3");
        result = new BigDecimal("3.34");
        harness.check(a.divide(b, 2, RoundingMode.UP), result);
        result = new BigDecimal("3.33");
        harness.check(a.divide(b, 2, RoundingMode.DOWN), result);
        result = new BigDecimal("3.34");
        harness.check(a.divide(b, 2, RoundingMode.CEILING), result);
        result = new BigDecimal("3.33");
        harness.check(a.divide(b, 2, RoundingMode.FLOOR), result);
        result = new BigDecimal("3.33");
        harness.check(a.divide(b, 2, RoundingMode.HALF_UP), result);
        result = new BigDecimal("3.33");
        harness.check(a.divide(b, 2, RoundingMode.HALF_DOWN), result);
        result = new BigDecimal("3.33");
        harness.check(a.divide(b, 2, RoundingMode.HALF_EVEN), result);
        harness.checkPoint("negative result, scale=2");
        a = new BigDecimal("10");
        b = new BigDecimal("-3");
        result = new BigDecimal("-3.34");
        harness.check(a.divide(b, 2, RoundingMode.UP), result);
        result = new BigDecimal("-3.33");
        harness.check(a.divide(b, 2, RoundingMode.DOWN), result);
        result = new BigDecimal("-3.33");
        harness.check(a.divide(b, 2, RoundingMode.CEILING), result);
        result = new BigDecimal("-3.34");
        harness.check(a.divide(b, 2, RoundingMode.FLOOR), result);
        result = new BigDecimal("-3.33");
        harness.check(a.divide(b, 2, RoundingMode.HALF_UP), result);
        result = new BigDecimal("-3.33");
        harness.check(a.divide(b, 2, RoundingMode.HALF_DOWN), result);
        result = new BigDecimal("-3.33");
        harness.check(a.divide(b, 2, RoundingMode.HALF_EVEN), result);
        harness.checkPoint("negative result, second test case, scale=2");
        a = new BigDecimal("-10");
        b = new BigDecimal("3");
        result = new BigDecimal("-3.34");
        harness.check(a.divide(b, 2, RoundingMode.UP), result);
        result = new BigDecimal("-3.33");
        harness.check(a.divide(b, 2, RoundingMode.DOWN), result);
        result = new BigDecimal("-3.33");
        harness.check(a.divide(b, 2, RoundingMode.CEILING), result);
        result = new BigDecimal("-3.34");
        harness.check(a.divide(b, 2, RoundingMode.FLOOR), result);
        result = new BigDecimal("-3.33");
        harness.check(a.divide(b, 2, RoundingMode.HALF_UP), result);
        result = new BigDecimal("-3.33");
        harness.check(a.divide(b, 2, RoundingMode.HALF_DOWN), result);
        result = new BigDecimal("-3.33");
        harness.check(a.divide(b, 2, RoundingMode.HALF_EVEN), result);
    }
}

