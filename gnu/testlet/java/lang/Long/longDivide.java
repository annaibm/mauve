/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class longDivide
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testDividePositiveByPositiveCase1(harness);
        this.testDividePositiveByPositiveCase2(harness);
        this.testDividePositiveByPositiveCase3(harness);
        this.testDividePositiveByNegativeCase1(harness);
        this.testDividePositiveByNegativeCase2(harness);
        this.testDividePositiveByNegativeCase3(harness);
        this.testDivideNegativeByPositiveCase1(harness);
        this.testDivideNegativeByPositiveCase2(harness);
        this.testDivideNegativeByPositiveCase3(harness);
        this.testDivideNegativeByNegativeCase1(harness);
        this.testDivideNegativeByNegativeCase2(harness);
        this.testDivideNegativeByNegativeCase3(harness);
        this.testDivideMaxValue(harness);
        this.testDivideMinValue(harness);
        this.testDivideByMaxValue(harness);
        this.testDivideByMinValue(harness);
        this.testDivideByZeroCase1(harness);
        this.testDivideByZeroCase2(harness);
        this.testDivideByZeroCase3(harness);
        this.testDivideByZeroCase4(harness);
        this.testDivideByZeroCase5(harness);
    }

    public void testDividePositiveByPositiveCase1(TestHarness harness) {
        long x = 10L;
        long y = 2L;
        long z = x / y;
        harness.check(z == 5L);
    }

    public void testDividePositiveByPositiveCase2(TestHarness harness) {
        long x = 10L;
        long y = 3L;
        long z = x / y;
        harness.check(z == 3L);
    }

    public void testDividePositiveByPositiveCase3(TestHarness harness) {
        long x = 11L;
        long y = 3L;
        long z = x / y;
        harness.check(z == 3L);
    }

    public void testDividePositiveByNegativeCase1(TestHarness harness) {
        long x = 10L;
        long y = -2L;
        long z = x / y;
        harness.check(z == -5L);
    }

    public void testDividePositiveByNegativeCase2(TestHarness harness) {
        long x = 10L;
        long y = -3L;
        long z = x / y;
        harness.check(z == -3L);
    }

    public void testDividePositiveByNegativeCase3(TestHarness harness) {
        long x = 11L;
        long y = -3L;
        long z = x / y;
        harness.check(z == -3L);
    }

    public void testDivideNegativeByPositiveCase1(TestHarness harness) {
        long x = -10L;
        long y = 2L;
        long z = x / y;
        harness.check(z == -5L);
    }

    public void testDivideNegativeByPositiveCase2(TestHarness harness) {
        long x = -10L;
        long y = 3L;
        long z = x / y;
        harness.check(z == -3L);
    }

    public void testDivideNegativeByPositiveCase3(TestHarness harness) {
        long x = -11L;
        long y = 3L;
        long z = x / y;
        harness.check(z == -3L);
    }

    public void testDivideNegativeByNegativeCase1(TestHarness harness) {
        long x = -10L;
        long y = -2L;
        long z = x / y;
        harness.check(z == 5L);
    }

    public void testDivideNegativeByNegativeCase2(TestHarness harness) {
        long x = -10L;
        long y = -3L;
        long z = x / y;
        harness.check(z == 3L);
    }

    public void testDivideNegativeByNegativeCase3(TestHarness harness) {
        long x = -11L;
        long y = -3L;
        long z = x / y;
        harness.check(z == 3L);
    }

    public void testDivideMaxValue(TestHarness harness) {
        long x = Integer.MAX_VALUE;
        long y = 65536L;
        long z = x / y;
        harness.check(z == 32767L);
    }

    public void testDivideMinValue(TestHarness harness) {
        long x = Integer.MIN_VALUE;
        long y = 65536L;
        long z = x / y;
        harness.check(z == -32768L);
    }

    public void testDivideByMaxValue(TestHarness harness) {
        long x = Integer.MAX_VALUE;
        long y = Integer.MAX_VALUE;
        long z = x / y;
        harness.check(z == 1L);
    }

    public void testDivideByMinValue(TestHarness harness) {
        long x = Integer.MIN_VALUE;
        long y = Integer.MIN_VALUE;
        long z = x / y;
        harness.check(z == 1L);
    }

    public void testDivideByZeroCase1(TestHarness harness) {
        long x = 1L;
        long y = 0L;
        try {
            long z = x / y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testDivideByZeroCase2(TestHarness harness) {
        long x = -1L;
        long y = 0L;
        try {
            long z = x / y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testDivideByZeroCase3(TestHarness harness) {
        long x = Integer.MAX_VALUE;
        long y = 0L;
        try {
            long z = x / y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testDivideByZeroCase4(TestHarness harness) {
        long x = Integer.MIN_VALUE;
        long y = 0L;
        try {
            long z = x / y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testDivideByZeroCase5(TestHarness harness) {
        long x = 0L;
        long y = 0L;
        try {
            long z = x / y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }
}

