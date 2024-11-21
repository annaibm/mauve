/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;
import java.math.MathContext;

public class abs
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness, new MathContext(0));
        this.test2(harness, new MathContext(1));
        this.test2(harness, new MathContext(2));
        this.test3(harness);
    }

    private void test1(TestHarness harness) {
        harness.check(new BigDecimal("2").abs().toString().equals("2"));
        harness.check(new BigDecimal("-2").abs().toString().equals("2"));
        harness.check(new BigDecimal("+0.000").abs().toString().equals("0.000"));
        harness.check(new BigDecimal("00.000").abs().toString().equals("0.000"));
        harness.check(new BigDecimal("-0.000").abs().toString().equals("0.000"));
        harness.check(new BigDecimal("-2000000").abs().toString().equals("2000000"));
        harness.check(new BigDecimal("0.2").abs().toString().equals("0.2"));
        harness.check(new BigDecimal("-0.2").abs().toString().equals("0.2"));
        harness.check(new BigDecimal("0.01").abs().toString().equals("0.01"));
        harness.check(new BigDecimal("-0.01").abs().toString().equals("0.01"));
    }

    private void test2(TestHarness harness, MathContext mathContext) {
        harness.check(new BigDecimal("2").abs(mathContext).toString().equals("2"));
        harness.check(new BigDecimal("-2").abs(mathContext).toString().equals("2"));
        harness.check(new BigDecimal("+0.000").abs(mathContext).toString().equals("0.000"));
        harness.check(new BigDecimal("00.000").abs(mathContext).toString().equals("0.000"));
        harness.check(new BigDecimal("-0.000").abs(mathContext).toString().equals("0.000"));
        harness.check(new BigDecimal("0.2").abs(mathContext).toString().equals("0.2"));
        harness.check(new BigDecimal("-0.2").abs(mathContext).toString().equals("0.2"));
        harness.check(new BigDecimal("0.01").abs(mathContext).toString().equals("0.01"));
        harness.check(new BigDecimal("-0.01").abs(mathContext).toString().equals("0.01"));
    }

    private void test3(TestHarness harness) {
        harness.check(new BigDecimal("-2000000").abs(new MathContext(0)).toString().equals("2000000"));
        harness.check(new BigDecimal("-2000000").abs(new MathContext(1)).toString().equals("2E+6"));
        harness.check(new BigDecimal("-2000000").abs(new MathContext(2)).toString().equals("2.0E+6"));
        harness.check(new BigDecimal("-2000000").abs(new MathContext(3)).toString().equals("2.00E+6"));
    }
}

