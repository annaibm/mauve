/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;
import java.math.MathContext;

public class multiply
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness, new MathContext(0));
        this.test3(harness, new MathContext(1));
        this.test4(harness);
    }

    private void test1(TestHarness harness) {
        BigDecimal secondNumber = new BigDecimal("2");
        harness.check(new BigDecimal("2").multiply(secondNumber).toString().equals("4"));
        harness.check(new BigDecimal("-2").multiply(secondNumber).toString().equals("-4"));
        harness.check(new BigDecimal("+0.000").multiply(secondNumber).toString().equals("0.000"));
        harness.check(new BigDecimal("00.000").multiply(secondNumber).toString().equals("0.000"));
        harness.check(new BigDecimal("-0.000").multiply(secondNumber).toString().equals("0.000"));
        harness.check(new BigDecimal("2000000").multiply(secondNumber).toString().equals("4000000"));
        harness.check(new BigDecimal("0.2").multiply(secondNumber).toString().equals("0.4"));
        harness.check(new BigDecimal("-0.2").multiply(secondNumber).toString().equals("-0.4"));
        harness.check(new BigDecimal("0.01").multiply(secondNumber).toString().equals("0.02"));
        harness.check(new BigDecimal("-0.01").multiply(secondNumber).toString().equals("-0.02"));
    }

    private void test2(TestHarness harness, MathContext mathContext) {
        BigDecimal secondNumber = new BigDecimal("2");
        harness.check(new BigDecimal("2").multiply(secondNumber, mathContext).toString().equals("4"));
        harness.check(new BigDecimal("-2").multiply(secondNumber, mathContext).toString().equals("-4"));
        harness.check(new BigDecimal("+0.000").multiply(secondNumber, mathContext).toString().equals("0.000"));
        harness.check(new BigDecimal("00.000").multiply(secondNumber, mathContext).toString().equals("0.000"));
        harness.check(new BigDecimal("-0.000").multiply(secondNumber, mathContext).toString().equals("0.000"));
        harness.check(new BigDecimal("2000000").multiply(secondNumber, mathContext).toString().equals("4000000"));
        harness.check(new BigDecimal("0.2").multiply(secondNumber, mathContext).toString().equals("0.4"));
        harness.check(new BigDecimal("-0.2").multiply(secondNumber, mathContext).toString().equals("-0.4"));
        harness.check(new BigDecimal("0.01").multiply(secondNumber, mathContext).toString().equals("0.02"));
        harness.check(new BigDecimal("-0.01").multiply(secondNumber, mathContext).toString().equals("-0.02"));
    }

    private void test3(TestHarness harness, MathContext mathContext) {
        BigDecimal secondNumber = new BigDecimal("2");
        harness.check(new BigDecimal("2").multiply(secondNumber, mathContext).toString().equals("4"));
        harness.check(new BigDecimal("-2").multiply(secondNumber, mathContext).toString().equals("-4"));
        harness.check(new BigDecimal("+0.000").multiply(secondNumber, mathContext).toString().equals("0.000"));
        harness.check(new BigDecimal("00.000").multiply(secondNumber, mathContext).toString().equals("0.000"));
        harness.check(new BigDecimal("-0.000").multiply(secondNumber, mathContext).toString().equals("0.000"));
        harness.check(new BigDecimal("2000000").multiply(secondNumber, mathContext).toString().equals("4E+6"));
        harness.check(new BigDecimal("0.2").multiply(secondNumber, mathContext).toString().equals("0.4"));
        harness.check(new BigDecimal("-0.2").multiply(secondNumber, mathContext).toString().equals("-0.4"));
        harness.check(new BigDecimal("0.01").multiply(secondNumber, mathContext).toString().equals("0.02"));
        harness.check(new BigDecimal("-0.01").multiply(secondNumber, mathContext).toString().equals("-0.02"));
    }

    private void test4(TestHarness harness) {
        BigDecimal secondNumber = new BigDecimal("2");
        harness.check(new BigDecimal("2000000").multiply(secondNumber, new MathContext(0)).toString().equals("4000000"));
        harness.check(new BigDecimal("2000000").multiply(secondNumber, new MathContext(1)).toString().equals("4E+6"));
        harness.check(new BigDecimal("2000000").multiply(secondNumber, new MathContext(2)).toString().equals("4.0E+6"));
        harness.check(new BigDecimal("2000000").multiply(secondNumber, new MathContext(3)).toString().equals("4.00E+6"));
    }
}

