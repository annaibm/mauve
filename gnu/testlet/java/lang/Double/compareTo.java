/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class compareTo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("compareTo(Double)");
        Double d1 = new Double(Double.NEGATIVE_INFINITY);
        Double d2 = new Double(-1.0);
        Double d3 = new Double(0.0);
        Double d4 = new Double(1.0);
        Double d5 = new Double(Double.POSITIVE_INFINITY);
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
            d1.compareTo((Float)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("compareTo(Object)");
        Double d1 = new Double(Double.NEGATIVE_INFINITY);
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
            d1.compareTo("Not a Double!");
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

