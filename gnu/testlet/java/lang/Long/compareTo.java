/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Long;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class compareTo
implements Testlet {
    public static final int LESS = -1;
    public static final int EQUAL = 0;
    public static final int GREATER = 1;
    TestHarness harness;

    void compare(Long l1, Long l2, int expected) {
        int result = l1.compareTo(l2);
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
        result = l2.compareTo(l1);
        switch (expected) {
            case -1: {
                this.harness.check(result > 0);
                break;
            }
            case 0: {
                this.harness.check(result == 0);
                break;
            }
            case 1: {
                this.harness.check(result < 0);
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
        Long min2 = new Long(Long.MIN_VALUE);
        Long negone = new Long(-1L);
        Long zero = new Long(0L);
        Long posone = new Long(1L);
        Long max2 = new Long(Long.MAX_VALUE);
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
        Long o = zero;
        harness.check(zero.compareTo(o) == 0);
        boolean ok = false;
        try {
            zero.compareTo((Long)null);
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

