/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class longModulo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testModuloPositiveByPositiveCase1(harness);
        this.testModuloPositiveByPositiveCase2(harness);
        this.testModuloPositiveByPositiveCase3(harness);
        this.testModuloPositiveByNegativeCase1(harness);
        this.testModuloPositiveByNegativeCase2(harness);
        this.testModuloPositiveByNegativeCase3(harness);
        this.testModuloNegativeByPositiveCase1(harness);
        this.testModuloNegativeByPositiveCase2(harness);
        this.testModuloNegativeByPositiveCase3(harness);
        this.testModuloNegativeByNegativeCase1(harness);
        this.testModuloNegativeByNegativeCase2(harness);
        this.testModuloNegativeByNegativeCase3(harness);
        this.testModuloMaxValue(harness);
        this.testModuloMinValue(harness);
        this.testModuloByMaxValue(harness);
        this.testModuloByMinValue(harness);
        this.testModuloByZeroCase1(harness);
        this.testModuloByZeroCase2(harness);
        this.testModuloByZeroCase3(harness);
        this.testModuloByZeroCase4(harness);
        this.testModuloByZeroCase5(harness);
    }

    public void testModuloPositiveByPositiveCase1(TestHarness harness) {
        long x = 10L;
        long y = 2L;
        long z = x % y;
        harness.check(z == 0L);
    }

    public void testModuloPositiveByPositiveCase2(TestHarness harness) {
        long x = 10L;
        long y = 3L;
        long z = x % y;
        harness.check(z == 1L);
    }

    public void testModuloPositiveByPositiveCase3(TestHarness harness) {
        long x = 11L;
        long y = 3L;
        long z = x % y;
        harness.check(z == 2L);
    }

    public void testModuloPositiveByNegativeCase1(TestHarness harness) {
        long x = 10L;
        long y = -2L;
        long z = x % y;
        harness.check(z == 0L);
    }

    public void testModuloPositiveByNegativeCase2(TestHarness harness) {
        long x = 10L;
        long y = -3L;
        long z = x % y;
        harness.check(z == 1L);
    }

    public void testModuloPositiveByNegativeCase3(TestHarness harness) {
        long x = 11L;
        long y = -3L;
        long z = x % y;
        harness.check(z == 2L);
    }

    public void testModuloNegativeByPositiveCase1(TestHarness harness) {
        long x = -10L;
        long y = 2L;
        long z = x % y;
        harness.check(z == 0L);
    }

    public void testModuloNegativeByPositiveCase2(TestHarness harness) {
        long x = -10L;
        long y = 3L;
        long z = x % y;
        harness.check(z == -1L);
    }

    public void testModuloNegativeByPositiveCase3(TestHarness harness) {
        long x = -11L;
        long y = 3L;
        long z = x % y;
        harness.check(z == -2L);
    }

    public void testModuloNegativeByNegativeCase1(TestHarness harness) {
        long x = -10L;
        long y = -2L;
        long z = x % y;
        harness.check(z == 0L);
    }

    public void testModuloNegativeByNegativeCase2(TestHarness harness) {
        long x = -10L;
        long y = -3L;
        long z = x % y;
        harness.check(z == -1L);
    }

    public void testModuloNegativeByNegativeCase3(TestHarness harness) {
        long x = -11L;
        long y = -3L;
        long z = x % y;
        harness.check(z == -2L);
    }

    public void testModuloMaxValue(TestHarness harness) {
        long x = Integer.MAX_VALUE;
        long y = 65536L;
        long z = x % y;
        harness.check(z == 65535L);
    }

    public void testModuloMinValue(TestHarness harness) {
        long x = Integer.MIN_VALUE;
        long y = 65536L;
        long z = x % y;
        harness.check(z == 0L);
    }

    public void testModuloByMaxValue(TestHarness harness) {
        long x = Integer.MAX_VALUE;
        long y = Integer.MAX_VALUE;
        long z = x % y;
        harness.check(z == 0L);
    }

    public void testModuloByMinValue(TestHarness harness) {
        long x = Integer.MIN_VALUE;
        long y = Integer.MIN_VALUE;
        long z = x % y;
        harness.check(z == 0L);
    }

    public void testModuloByZeroCase1(TestHarness harness) {
        long x = 1L;
        long y = 0L;
        try {
            long z = x % y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testModuloByZeroCase2(TestHarness harness) {
        long x = -1L;
        long y = 0L;
        try {
            long z = x % y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testModuloByZeroCase3(TestHarness harness) {
        long x = Integer.MAX_VALUE;
        long y = 0L;
        try {
            long z = x % y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testModuloByZeroCase4(TestHarness harness) {
        long x = Integer.MIN_VALUE;
        long y = 0L;
        try {
            long z = x % y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testModuloByZeroCase5(TestHarness harness) {
        long x = 0L;
        long y = 0L;
        try {
            long z = x % y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }
}

