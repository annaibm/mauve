/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class integerDivide
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
        int x = 10;
        int y = 2;
        int z = x / y;
        harness.check(z == 5);
    }

    public void testDividePositiveByPositiveCase2(TestHarness harness) {
        int x = 10;
        int y = 3;
        int z = x / y;
        harness.check(z == 3);
    }

    public void testDividePositiveByPositiveCase3(TestHarness harness) {
        int x = 11;
        int y = 3;
        int z = x / y;
        harness.check(z == 3);
    }

    public void testDividePositiveByNegativeCase1(TestHarness harness) {
        int x = 10;
        int y = -2;
        int z = x / y;
        harness.check(z == -5);
    }

    public void testDividePositiveByNegativeCase2(TestHarness harness) {
        int x = 10;
        int y = -3;
        int z = x / y;
        harness.check(z == -3);
    }

    public void testDividePositiveByNegativeCase3(TestHarness harness) {
        int x = 11;
        int y = -3;
        int z = x / y;
        harness.check(z == -3);
    }

    public void testDivideNegativeByPositiveCase1(TestHarness harness) {
        int x = -10;
        int y = 2;
        int z = x / y;
        harness.check(z == -5);
    }

    public void testDivideNegativeByPositiveCase2(TestHarness harness) {
        int x = -10;
        int y = 3;
        int z = x / y;
        harness.check(z == -3);
    }

    public void testDivideNegativeByPositiveCase3(TestHarness harness) {
        int x = -11;
        int y = 3;
        int z = x / y;
        harness.check(z == -3);
    }

    public void testDivideNegativeByNegativeCase1(TestHarness harness) {
        int x = -10;
        int y = -2;
        int z = x / y;
        harness.check(z == 5);
    }

    public void testDivideNegativeByNegativeCase2(TestHarness harness) {
        int x = -10;
        int y = -3;
        int z = x / y;
        harness.check(z == 3);
    }

    public void testDivideNegativeByNegativeCase3(TestHarness harness) {
        int x = -11;
        int y = -3;
        int z = x / y;
        harness.check(z == 3);
    }

    public void testDivideMaxValue(TestHarness harness) {
        int x = Integer.MAX_VALUE;
        int y = 65536;
        int z = x / y;
        harness.check(z == Short.MAX_VALUE);
    }

    public void testDivideMinValue(TestHarness harness) {
        int x = Integer.MIN_VALUE;
        int y = 65536;
        int z = x / y;
        harness.check(z == Short.MIN_VALUE);
    }

    public void testDivideByMaxValue(TestHarness harness) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int z = x / y;
        harness.check(z == 1);
    }

    public void testDivideByMinValue(TestHarness harness) {
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        int z = x / y;
        harness.check(z == 1);
    }

    public void testDivideByZeroCase1(TestHarness harness) {
        int x = 1;
        int y = 0;
        try {
            int z = x / y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testDivideByZeroCase2(TestHarness harness) {
        int x = -1;
        int y = 0;
        try {
            int z = x / y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testDivideByZeroCase3(TestHarness harness) {
        int x = Integer.MAX_VALUE;
        int y = 0;
        try {
            int z = x / y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testDivideByZeroCase4(TestHarness harness) {
        int x = Integer.MIN_VALUE;
        int y = 0;
        try {
            int z = x / y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testDivideByZeroCase5(TestHarness harness) {
        int x = 0;
        int y = 0;
        try {
            int z = x / y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }
}

