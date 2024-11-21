/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;
import java.math.MathContext;

public class pow
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness, new MathContext(0));
        this.test3(harness, new MathContext(1));
        this.test4(harness);
    }

    private void test1(TestHarness harness) {
        TestCase[] testCases = new TestCase[]{new TestCase("0", 0, "1"), new TestCase("1", 0, "1"), new TestCase("0", 1, "0"), new TestCase("2", 2, "4"), new TestCase("2", 2, "4"), new TestCase("2.", 2, "4"), new TestCase("2.0", 2, "4.00"), new TestCase("2.00", 2, "4.0000"), new TestCase("2.000", 2, "4.000000"), new TestCase("-0", 0, "1"), new TestCase("-1", 0, "1"), new TestCase("-0", 1, "0"), new TestCase("-2", 2, "4"), new TestCase("-2", 2, "4"), new TestCase("-2.", 2, "4"), new TestCase("-2.0", 2, "4.00"), new TestCase("-2.00", 2, "4.0000"), new TestCase("-2.000", 2, "4.000000")};
        for (int i = 0; i < testCases.length; ++i) {
            TestCase testCase = testCases[i];
            harness.check(new BigDecimal(testCase.input).pow(testCase.power).toString().equals(testCase.output));
        }
    }

    private void test2(TestHarness harness, MathContext mathContext) {
        TestCase[] testCases = new TestCase[]{new TestCase("0", 0, "1"), new TestCase("1", 0, "1"), new TestCase("0", 1, "0"), new TestCase("2", 2, "4"), new TestCase("2", 2, "4"), new TestCase("2.", 2, "4"), new TestCase("2.0", 2, "4.00"), new TestCase("2.00", 2, "4.0000"), new TestCase("2.000", 2, "4.000000"), new TestCase("-0", 0, "1"), new TestCase("-1", 0, "1"), new TestCase("-0", 1, "0"), new TestCase("-2", 2, "4"), new TestCase("-2", 2, "4"), new TestCase("-2.", 2, "4"), new TestCase("-2.0", 2, "4.00"), new TestCase("-2.00", 2, "4.0000"), new TestCase("-2.000", 2, "4.000000")};
        for (int i = 0; i < testCases.length; ++i) {
            TestCase testCase = testCases[i];
            harness.check(new BigDecimal(testCase.input).pow(testCase.power).toString().equals(testCase.output));
        }
    }

    private void test3(TestHarness harness, MathContext mathContext) {
        TestCase[] testCases = new TestCase[]{new TestCase("0", 0, "1"), new TestCase("1", 0, "1"), new TestCase("0", 1, "0"), new TestCase("2", 2, "4"), new TestCase("2", 2, "4"), new TestCase("2.", 2, "4"), new TestCase("2.0", 2, "4.00"), new TestCase("2.00", 2, "4.0000"), new TestCase("2.000", 2, "4.000000"), new TestCase("-0", 0, "1"), new TestCase("-1", 0, "1"), new TestCase("-0", 1, "0"), new TestCase("-2", 2, "4"), new TestCase("-2", 2, "4"), new TestCase("-2.", 2, "4"), new TestCase("-2.0", 2, "4.00"), new TestCase("-2.00", 2, "4.0000"), new TestCase("-2.000", 2, "4.000000")};
        for (int i = 0; i < testCases.length; ++i) {
            TestCase testCase = testCases[i];
            harness.check(new BigDecimal(testCase.input).pow(testCase.power).toString().equals(testCase.output));
        }
    }

    private void test4(TestHarness harness) {
        harness.check(new BigDecimal("2000000").pow(1, new MathContext(0)).toString().equals("2000000"));
        harness.check(new BigDecimal("2000000").pow(-2, new MathContext(1)).toString().equals("3E-13"));
    }

    class TestCase {
        public String input;
        public int power;
        public String output;

        public TestCase(String input, int power, String output) {
            this.input = input;
            this.power = power;
            this.output = output;
        }
    }
}

