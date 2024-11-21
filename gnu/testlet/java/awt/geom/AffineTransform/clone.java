/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t1 = new AffineTransform(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        AffineTransform t2 = null;
        t2 = (AffineTransform)t1.clone();
        harness.check(t2.getScaleX(), 1.0);
        harness.check(t2.getScaleY(), 4.0);
        harness.check(t2.getTranslateX(), 5.0);
        harness.check(t2.getTranslateY(), 6.0);
        harness.check(t2.getShearX(), 3.0);
        harness.check(t2.getShearY(), 2.0);
        harness.check(t2.getType() == 32);
    }
}

