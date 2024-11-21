/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class compareTo
implements Testlet {
    public static final int LESS = -1;
    public static final int EQUAL = 0;
    public static final int GREATER = 1;
    TestHarness harness;

    void compare(Integer i1, Integer i2, int expected) {
        int result = i1.compareTo(i2);
        switch (expected) {
            case -1: {
                this.harness.check(result < 0);
                break;
            }
            case 0: {
                this.harness.check(result == 0);
                break;
            }
            case 1: {
                this.harness.check(result > 0);
                break;
            }
            default: {
                throw new Error();
            }
        }
    }

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        Integer min2 = new Integer(Integer.MIN_VALUE);
        Integer negone = new Integer(-1);
        Integer zero = new Integer(0);
        Integer posone = new Integer(1);
        Integer max2 = new Integer(Integer.MAX_VALUE);
        harness.checkPoint("compareTo");
        this.compare(min2, min2, 0);
        this.compare(min2, negone, -1);
        this.compare(min2, zero, -1);
        this.compare(min2, posone, -1);
        this.compare(min2, max2, -1);
        this.compare(negone, min2, 1);
        this.compare(negone, negone, 0);
        this.compare(negone, zero, -1);
        this.compare(negone, posone, -1);
        this.compare(negone, max2, -1);
        this.compare(zero, min2, 1);
        this.compare(zero, negone, 1);
        this.compare(zero, zero, 0);
        this.compare(zero, posone, -1);
        this.compare(zero, max2, -1);
        this.compare(posone, min2, 1);
        this.compare(posone, negone, 1);
        this.compare(posone, zero, 1);
        this.compare(posone, posone, 0);
        this.compare(posone, max2, -1);
        this.compare(max2, min2, 1);
        this.compare(max2, negone, 1);
        this.compare(max2, zero, 1);
        this.compare(max2, posone, 1);
        this.compare(max2, max2, 0);
        Integer o = zero;
        harness.check(zero.compareTo(o) == 0);
        boolean ok = false;
        try {
            zero.compareTo((Integer)null);
        }
        catch (NullPointerException e) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            zero.compareTo(null);
        }
        catch (NullPointerException e) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            zero.compareTo(new Object());
        }
        catch (ClassCastException e) {
            ok = true;
        }
        harness.check(ok);
    }
}

