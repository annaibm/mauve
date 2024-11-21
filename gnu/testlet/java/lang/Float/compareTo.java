/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float;

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
        harness.checkPoint("compareTo(Float)");
        Float f1 = new Float(Float.NEGATIVE_INFINITY);
        Float f2 = new Float(-1.0);
        Float f3 = new Float(0.0);
        Float f4 = new Float(1.0);
        Float f5 = new Float(Float.POSITIVE_INFINITY);
        harness.check(f1.compareTo(f1) == 0);
        harness.check(f1.compareTo(f2) < 0);
        harness.check(f1.compareTo(f3) < 0);
        harness.check(f1.compareTo(f4) < 0);
        harness.check(f1.compareTo(f5) < 0);
        harness.check(f2.compareTo(f1) > 0);
        harness.check(f2.compareTo(f2) == 0);
        harness.check(f2.compareTo(f3) < 0);
        harness.check(f2.compareTo(f4) < 0);
        harness.check(f2.compareTo(f5) < 0);
        harness.check(f3.compareTo(f1) > 0);
        harness.check(f3.compareTo(f2) > 0);
        harness.check(f3.compareTo(f3) == 0);
        harness.check(f3.compareTo(f4) < 0);
        harness.check(f3.compareTo(f5) < 0);
        harness.check(f4.compareTo(f1) > 0);
        harness.check(f4.compareTo(f2) > 0);
        harness.check(f4.compareTo(f3) > 0);
        harness.check(f4.compareTo(f4) == 0);
        harness.check(f4.compareTo(f5) < 0);
        harness.check(f5.compareTo(f1) > 0);
        harness.check(f5.compareTo(f2) > 0);
        harness.check(f5.compareTo(f3) > 0);
        harness.check(f5.compareTo(f4) > 0);
        harness.check(f5.compareTo(f5) == 0);
        boolean pass = false;
        try {
            f1.compareTo((Float)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("compareTo(Object)");
        Float f1 = new Float(Float.NEGATIVE_INFINITY);
        boolean pass = false;
        try {
            f1.compareTo(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            f1.compareTo("Not a Float!");
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

