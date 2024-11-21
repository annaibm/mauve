/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class divide
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BigDecimal a;
        BigDecimal b = a = new BigDecimal("0");
        harness.checkPoint("basic tests");
        a = new BigDecimal("10");
        b = new BigDecimal("2");
        BigDecimal result = new BigDecimal("5");
        harness.check(a.divide(b), result);
        a = a.negate();
        b = b.negate();
        result = new BigDecimal("5");
        harness.check(a.divide(b), result);
        b = b.negate();
        result = new BigDecimal("-5");
        harness.check(a.divide(b), result);
        harness.checkPoint("unrounded zero");
        a = new BigDecimal("9");
        b = new BigDecimal("-100");
        result = new BigDecimal("0");
        harness.check(a.divide(b, 2), result);
        result = new BigDecimal("-1");
        harness.check(a.divide(b, 3), result);
        a = a.negate();
        b = b.negate();
        result = new BigDecimal("0");
        harness.check(a.divide(b, 2), result);
        result = new BigDecimal("-1");
        harness.check(a.divide(b, 3), result);
        a = new BigDecimal("66.70");
        b = new BigDecimal("2");
        result = new BigDecimal("33.35");
        harness.checkPoint("66.70 / 2");
        harness.check(a.divide(b, 0), result);
        harness.check(a.divide(b, 1), result);
        harness.check(a.divide(b, 2), result);
        harness.check(a.divide(b, 3), result);
        harness.check(a.divide(b, 4), result);
        harness.check(a.divide(b, 5), result);
        harness.check(a.divide(b, 6), result);
        harness.check(a.divide(b, 7), result);
        result = new BigDecimal("33");
        BigDecimal result_up = new BigDecimal("34");
        harness.checkPoint("66.70 / 2, scale 0");
        harness.check(a.divide(b, 0, 0), result_up);
        harness.check(a.divide(b, 0, 1), result);
        harness.check(a.divide(b, 0, 2), result_up);
        harness.check(a.divide(b, 0, 3), result);
        harness.check(a.divide(b, 0, 4), result);
        harness.check(a.divide(b, 0, 5), result);
        harness.check(a.divide(b, 0, 6), result);
        boolean exception = false;
        try {
            a.divide(b, 0, 7);
        }
        catch (ArithmeticException ae) {
            exception = true;
        }
        harness.check(exception);
        result = new BigDecimal("33.3");
        result_up = new BigDecimal("33.4");
        harness.checkPoint("66.70 / 2, scale 1");
        harness.check(a.divide(b, 1, 0), result_up);
        harness.check(a.divide(b, 1, 1), result);
        harness.check(a.divide(b, 1, 2), result_up);
        harness.check(a.divide(b, 1, 3), result);
        harness.check(a.divide(b, 1, 4), result_up);
        harness.check(a.divide(b, 1, 5), result);
        harness.check(a.divide(b, 1, 6), result_up);
        exception = false;
        try {
            a.divide(b, 1, 7);
        }
        catch (ArithmeticException ae) {
            exception = true;
        }
        harness.check(exception);
        result = new BigDecimal("33.35");
        harness.checkPoint("66.70 / 2, scale 2");
        harness.check(a.divide(b, 2, 0), result);
        harness.check(a.divide(b, 2, 1), result);
        harness.check(a.divide(b, 2, 2), result);
        harness.check(a.divide(b, 2, 3), result);
        harness.check(a.divide(b, 2, 4), result);
        harness.check(a.divide(b, 2, 5), result);
        harness.check(a.divide(b, 2, 6), result);
        harness.check(a.divide(b, 2, 7), result);
        result = new BigDecimal("33.350");
        harness.checkPoint("66.70 / 2, scale 3");
        harness.check(a.divide(b, 3, 0), result);
        harness.check(a.divide(b, 3, 1), result);
        harness.check(a.divide(b, 3, 2), result);
        harness.check(a.divide(b, 3, 3), result);
        harness.check(a.divide(b, 3, 4), result);
        harness.check(a.divide(b, 3, 5), result);
        harness.check(a.divide(b, 3, 6), result);
        harness.check(a.divide(b, 3, 7), result);
        a = new BigDecimal("-66.70");
        result = new BigDecimal("-33.35");
        harness.checkPoint("-66.70 / 2");
        harness.check(a.divide(b, 0), result);
        harness.check(a.divide(b, 1), result);
        harness.check(a.divide(b, 2), result);
        harness.check(a.divide(b, 3), result);
        harness.check(a.divide(b, 4), result);
        harness.check(a.divide(b, 5), result);
        harness.check(a.divide(b, 6), result);
        harness.check(a.divide(b, 7), result);
        result = new BigDecimal("-33");
        result_up = new BigDecimal("-34");
        harness.checkPoint("-66.70 / 2, scale 0");
        harness.check(a.divide(b, 0, 0), result_up);
        harness.check(a.divide(b, 0, 1), result);
        harness.check(a.divide(b, 0, 2), result);
        harness.check(a.divide(b, 0, 3), result_up);
        harness.check(a.divide(b, 0, 4), result);
        harness.check(a.divide(b, 0, 5), result);
        harness.check(a.divide(b, 0, 6), result);
        exception = false;
        try {
            a.divide(b, 0, 7);
        }
        catch (ArithmeticException ae) {
            exception = true;
        }
        harness.check(exception);
        result = new BigDecimal("-33.3");
        result_up = new BigDecimal("-33.4");
        harness.checkPoint("-66.70 / 2, scale 1");
        harness.check(a.divide(b, 1, 0), result_up);
        harness.check(a.divide(b, 1, 1), result);
        harness.check(a.divide(b, 1, 2), result);
        harness.check(a.divide(b, 1, 3), result_up);
        harness.check(a.divide(b, 1, 4), result_up);
        harness.check(a.divide(b, 1, 5), result);
        harness.check(a.divide(b, 1, 6), result_up);
        exception = false;
        try {
            a.divide(b, 1, 7);
        }
        catch (ArithmeticException ae) {
            exception = true;
        }
        harness.check(exception);
        result = new BigDecimal("-33.35");
        harness.checkPoint("-66.70 / 2, scale 2");
        harness.check(a.divide(b, 2, 0), result);
        harness.check(a.divide(b, 2, 1), result);
        harness.check(a.divide(b, 2, 2), result);
        harness.check(a.divide(b, 2, 3), result);
        harness.check(a.divide(b, 2, 4), result);
        harness.check(a.divide(b, 2, 5), result);
        harness.check(a.divide(b, 2, 6), result);
        harness.check(a.divide(b, 2, 7), result);
        result = new BigDecimal("-33.350");
        harness.checkPoint("-66.70 / 2, scale 3");
        harness.check(a.divide(b, 3, 0), result);
        harness.check(a.divide(b, 3, 1), result);
        harness.check(a.divide(b, 3, 2), result);
        harness.check(a.divide(b, 3, 3), result);
        harness.check(a.divide(b, 3, 4), result);
        harness.check(a.divide(b, 3, 5), result);
        harness.check(a.divide(b, 3, 6), result);
        harness.check(a.divide(b, 3, 7), result);
        a = new BigDecimal("66.70");
        b = new BigDecimal("-2");
        result = new BigDecimal("-33.35");
        harness.checkPoint("66.70 / -2");
        harness.check(a.divide(b, 0), result);
        harness.check(a.divide(b, 1), result);
        harness.check(a.divide(b, 2), result);
        harness.check(a.divide(b, 3), result);
        harness.check(a.divide(b, 4), result);
        harness.check(a.divide(b, 5), result);
        harness.check(a.divide(b, 6), result);
        harness.check(a.divide(b, 7), result);
        result = new BigDecimal("-33");
        result_up = new BigDecimal("-34");
        harness.checkPoint("66.70 / -2, scale 0");
        harness.check(a.divide(b, 0, 0), result_up);
        harness.check(a.divide(b, 0, 1), result);
        harness.check(a.divide(b, 0, 2), result);
        harness.check(a.divide(b, 0, 3), result_up);
        harness.check(a.divide(b, 0, 4), result);
        harness.check(a.divide(b, 0, 5), result);
        harness.check(a.divide(b, 0, 6), result);
        exception = false;
        try {
            a.divide(b, 0, 7);
        }
        catch (ArithmeticException ae) {
            exception = true;
        }
        harness.check(exception);
        result = new BigDecimal("-33.3");
        result_up = new BigDecimal("-33.4");
        harness.checkPoint("66.70 / -2, scale 1");
        harness.check(a.divide(b, 1, 0), result_up);
        harness.check(a.divide(b, 1, 1), result);
        harness.check(a.divide(b, 1, 2), result);
        harness.check(a.divide(b, 1, 3), result_up);
        harness.check(a.divide(b, 1, 4), result_up);
        harness.check(a.divide(b, 1, 5), result);
        harness.check(a.divide(b, 1, 6), result_up);
        exception = false;
        try {
            a.divide(b, 1, 7);
        }
        catch (ArithmeticException ae) {
            exception = true;
        }
        harness.check(exception);
        result = new BigDecimal("-33.35");
        harness.checkPoint("66.70 / -2, scale 2");
        harness.check(a.divide(b, 2, 0), result);
        harness.check(a.divide(b, 2, 1), result);
        harness.check(a.divide(b, 2, 2), result);
        harness.check(a.divide(b, 2, 3), result);
        harness.check(a.divide(b, 2, 4), result);
        harness.check(a.divide(b, 2, 5), result);
        harness.check(a.divide(b, 2, 6), result);
        harness.check(a.divide(b, 2, 7), result);
        result = new BigDecimal("-33.350");
        harness.checkPoint("66.70 / -2, scale 3");
        harness.check(a.divide(b, 3, 0), result);
        harness.check(a.divide(b, 3, 1), result);
        harness.check(a.divide(b, 3, 2), result);
        harness.check(a.divide(b, 3, 3), result);
        harness.check(a.divide(b, 3, 4), result);
        harness.check(a.divide(b, 3, 5), result);
        harness.check(a.divide(b, 3, 6), result);
        harness.check(a.divide(b, 3, 7), result);
        a = new BigDecimal("-66.70");
        result = new BigDecimal("33.35");
        harness.checkPoint("-66.70 / -2");
        harness.check(a.divide(b, 0), result);
        harness.check(a.divide(b, 1), result);
        harness.check(a.divide(b, 2), result);
        harness.check(a.divide(b, 3), result);
        harness.check(a.divide(b, 4), result);
        harness.check(a.divide(b, 5), result);
        harness.check(a.divide(b, 6), result);
        harness.check(a.divide(b, 7), result);
        result = new BigDecimal("33");
        result_up = new BigDecimal("34");
        harness.checkPoint("-66.70 / -2, scale 0");
        harness.check(a.divide(b, 0, 0), result_up);
        harness.check(a.divide(b, 0, 1), result);
        harness.check(a.divide(b, 0, 2), result_up);
        harness.check(a.divide(b, 0, 3), result);
        harness.check(a.divide(b, 0, 4), result);
        harness.check(a.divide(b, 0, 5), result);
        harness.check(a.divide(b, 0, 6), result);
        exception = false;
        try {
            a.divide(b, 0, 7);
        }
        catch (ArithmeticException ae) {
            exception = true;
        }
        harness.check(exception);
        result = new BigDecimal("33.3");
        result_up = new BigDecimal("33.4");
        harness.checkPoint("-66.70 / -2, scale 1");
        harness.check(a.divide(b, 1, 0), result_up);
        harness.check(a.divide(b, 1, 1), result);
        harness.check(a.divide(b, 1, 2), result_up);
        harness.check(a.divide(b, 1, 3), result);
        harness.check(a.divide(b, 1, 4), result_up);
        harness.check(a.divide(b, 1, 5), result);
        harness.check(a.divide(b, 1, 6), result_up);
        exception = false;
        try {
            a.divide(b, 1, 7);
        }
        catch (ArithmeticException ae) {
            exception = true;
        }
        harness.check(exception);
        result = new BigDecimal("33.35");
        harness.checkPoint("-66.70 / -2, scale 2");
        harness.check(a.divide(b, 2, 0), result);
        harness.check(a.divide(b, 2, 1), result);
        harness.check(a.divide(b, 2, 2), result);
        harness.check(a.divide(b, 2, 3), result);
        harness.check(a.divide(b, 2, 4), result);
        harness.check(a.divide(b, 2, 5), result);
        harness.check(a.divide(b, 2, 6), result);
        harness.check(a.divide(b, 2, 7), result);
        result = new BigDecimal("33.350");
        harness.checkPoint("-66.70 / -2, scale 3");
        harness.check(a.divide(b, 3, 0), result);
        harness.check(a.divide(b, 3, 1), result);
        harness.check(a.divide(b, 3, 2), result);
        harness.check(a.divide(b, 3, 3), result);
        harness.check(a.divide(b, 3, 4), result);
        harness.check(a.divide(b, 3, 5), result);
        harness.check(a.divide(b, 3, 6), result);
        harness.check(a.divide(b, 3, 7), result);
    }
}

