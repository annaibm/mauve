/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Date;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Date;

public class compareTo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("compareTo(Date)");
        Date d1 = new Date(Long.MIN_VALUE);
        Date d2 = new Date(-1L);
        Date d3 = new Date(0L);
        Date d4 = new Date(1L);
        Date d5 = new Date(Long.MAX_VALUE);
        harness.check(d1.compareTo(d1) == 0);
        harness.check(d1.compareTo(d2) < 0);
        harness.check(d1.compareTo(d3) < 0);
        harness.check(d1.compareTo(d4) < 0);
        harness.check(d1.compareTo(d5) < 0);
        harness.check(d2.compareTo(d1) > 0);
        harness.check(d2.compareTo(d2) == 0);
        harness.check(d2.compareTo(d3) < 0);
        harness.check(d2.compareTo(d4) < 0);
        harness.check(d2.compareTo(d5) < 0);
        harness.check(d3.compareTo(d1) > 0);
        harness.check(d3.compareTo(d2) > 0);
        harness.check(d3.compareTo(d3) == 0);
        harness.check(d3.compareTo(d4) < 0);
        harness.check(d3.compareTo(d5) < 0);
        harness.check(d4.compareTo(d1) > 0);
        harness.check(d4.compareTo(d2) > 0);
        harness.check(d4.compareTo(d3) > 0);
        harness.check(d4.compareTo(d4) == 0);
        harness.check(d4.compareTo(d5) < 0);
        harness.check(d5.compareTo(d1) > 0);
        harness.check(d5.compareTo(d2) > 0);
        harness.check(d5.compareTo(d3) > 0);
        harness.check(d5.compareTo(d4) > 0);
        harness.check(d5.compareTo(d5) == 0);
        boolean pass = false;
        try {
            d1.compareTo((Date)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("compareTo(Object)");
        Date d1 = new Date(Long.MIN_VALUE);
        boolean pass = false;
        try {
            d1.compareTo(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            d1.compareTo("Not a Date!");
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

