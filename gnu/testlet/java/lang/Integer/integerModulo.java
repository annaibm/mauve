/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class integerModulo
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
        int x = 10;
        int y = 2;
        int z = x % y;
        harness.check(z == 0);
    }

    public void testModuloPositiveByPositiveCase2(TestHarness harness) {
        int x = 10;
        int y = 3;
        int z = x % y;
        harness.check(z == 1);
    }

    public void testModuloPositiveByPositiveCase3(TestHarness harness) {
        int x = 11;
        int y = 3;
        int z = x % y;
        harness.check(z == 2);
    }

    public void testModuloPositiveByNegativeCase1(TestHarness harness) {
        int x = 10;
        int y = -2;
        int z = x % y;
        harness.check(z == 0);
    }

    public void testModuloPositiveByNegativeCase2(TestHarness harness) {
        int x = 10;
        int y = -3;
        int z = x % y;
        harness.check(z == 1);
    }

    public void testModuloPositiveByNegativeCase3(TestHarness harness) {
        int x = 11;
        int y = -3;
        int z = x % y;
        harness.check(z == 2);
    }

    public void testModuloNegativeByPositiveCase1(TestHarness harness) {
        int x = -10;
        int y = 2;
        int z = x % y;
        harness.check(z == 0);
    }

    public void testModuloNegativeByPositiveCase2(TestHarness harness) {
        int x = -10;
        int y = 3;
        int z = x % y;
        harness.check(z == -1);
    }

    public void testModuloNegativeByPositiveCase3(TestHarness harness) {
        int x = -11;
        int y = 3;
        int z = x % y;
        harness.check(z == -2);
    }

    public void testModuloNegativeByNegativeCase1(TestHarness harness) {
        int x = -10;
        int y = -2;
        int z = x % y;
        harness.check(z == 0);
    }

    public void testModuloNegativeByNegativeCase2(TestHarness harness) {
        int x = -10;
        int y = -3;
        int z = x % y;
        harness.check(z == -1);
    }

    public void testModuloNegativeByNegativeCase3(TestHarness harness) {
        int x = -11;
        int y = -3;
        int z = x % y;
        harness.check(z == -2);
    }

    public void testModuloMaxValue(TestHarness harness) {
        int x = Integer.MAX_VALUE;
        int y = 65536;
        int z = x % y;
        harness.check(z == 65535);
    }

    public void testModuloMinValue(TestHarness harness) {
        int x = Integer.MIN_VALUE;
        int y = 65536;
        int z = x % y;
        harness.check(z == 0);
    }

    public void testModuloByMaxValue(TestHarness harness) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        int z = x % y;
        harness.check(z == 0);
    }

    public void testModuloByMinValue(TestHarness harness) {
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        int z = x % y;
        harness.check(z == 0);
    }

    public void testModuloByZeroCase1(TestHarness harness) {
        int x = 1;
        int y = 0;
        try {
            int z = x % y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testModuloByZeroCase2(TestHarness harness) {
        int x = -1;
        int y = 0;
        try {
            int z = x % y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testModuloByZeroCase3(TestHarness harness) {
        int x = Integer.MAX_VALUE;
        int y = 0;
        try {
            int z = x % y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testModuloByZeroCase4(TestHarness harness) {
        int x = Integer.MIN_VALUE;
        int y = 0;
        try {
            int z = x % y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }

    public void testModuloByZeroCase5(TestHarness harness) {
        int x = 0;
        int y = 0;
        try {
            int z = x % y;
            harness.check(false);
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
    }
}

