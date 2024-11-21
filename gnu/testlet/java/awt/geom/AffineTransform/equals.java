/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t1 = new AffineTransform(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        AffineTransform t2 = new AffineTransform(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        harness.check(t1.equals(t2));
        harness.check(t2.equals(t1));
        t1 = new AffineTransform(0.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        harness.check(!t1.equals(t2));
        t2 = new AffineTransform(0.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        harness.check(t1.equals(t2));
        t1 = new AffineTransform(1.0, 0.0, 3.0, 4.0, 5.0, 6.0);
        harness.check(!t1.equals(t2));
        t2 = new AffineTransform(1.0, 0.0, 3.0, 4.0, 5.0, 6.0);
        harness.check(t1.equals(t2));
        t1 = new AffineTransform(1.0, 2.0, 0.0, 4.0, 5.0, 6.0);
        harness.check(!t1.equals(t2));
        t2 = new AffineTransform(1.0, 2.0, 0.0, 4.0, 5.0, 6.0);
        harness.check(t1.equals(t2));
        t1 = new AffineTransform(1.0, 2.0, 3.0, 0.0, 5.0, 6.0);
        harness.check(!t1.equals(t2));
        t2 = new AffineTransform(1.0, 2.0, 3.0, 0.0, 5.0, 6.0);
        harness.check(t1.equals(t2));
        t1 = new AffineTransform(1.0, 2.0, 3.0, 4.0, 0.0, 6.0);
        harness.check(!t1.equals(t2));
        t2 = new AffineTransform(1.0, 2.0, 3.0, 4.0, 0.0, 6.0);
        harness.check(t1.equals(t2));
        t1 = new AffineTransform(1.0, 2.0, 3.0, 4.0, 5.0, 0.0);
        harness.check(!t1.equals(t2));
        t2 = new AffineTransform(1.0, 2.0, 3.0, 4.0, 5.0, 0.0);
        harness.check(t1.equals(t2));
    }
}

