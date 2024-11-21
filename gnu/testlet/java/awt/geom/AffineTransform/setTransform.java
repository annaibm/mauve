/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;

public class setTransform
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t1 = new AffineTransform();
        t1.setTransform(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        harness.check(t1.getScaleX(), 1.0);
        harness.check(t1.getShearY(), 2.0);
        harness.check(t1.getShearX(), 3.0);
        harness.check(t1.getScaleY(), 4.0);
        harness.check(t1.getTranslateX(), 5.0);
        harness.check(t1.getTranslateY(), 6.0);
        t1.setTransform(new AffineTransform(6.0, 5.0, 4.0, 3.0, 2.0, 1.0));
        harness.check(t1.getScaleX(), 6.0);
        harness.check(t1.getShearY(), 5.0);
        harness.check(t1.getShearX(), 4.0);
        harness.check(t1.getScaleY(), 3.0);
        harness.check(t1.getTranslateX(), 2.0);
        harness.check(t1.getTranslateY(), 1.0);
        boolean pass = false;
        try {
            t1.setTransform(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

