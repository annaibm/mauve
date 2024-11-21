/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;

public class preConcatenate
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t1 = new AffineTransform(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        AffineTransform t2 = new AffineTransform(7.0, 8.0, 9.0, 10.0, 11.0, 12.0);
        t1.preConcatenate(t2);
        harness.check(t1.getScaleX(), 25.0);
        harness.check(t1.getShearX(), 57.0);
        harness.check(t1.getTranslateX(), 100.0);
        harness.check(t1.getShearY(), 28.0);
        harness.check(t1.getScaleY(), 64.0);
        harness.check(t1.getTranslateY(), 112.0);
        boolean pass = false;
        try {
            t1.preConcatenate(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

