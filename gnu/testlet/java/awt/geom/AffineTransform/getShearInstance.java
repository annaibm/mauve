/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;

public class getShearInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t = AffineTransform.getShearInstance(1.0, 2.0);
        harness.check(t.getScaleX(), 1.0);
        harness.check(t.getShearX(), 1.0);
        harness.check(t.getTranslateX(), 0.0);
        harness.check(t.getShearY(), 2.0);
        harness.check(t.getScaleY(), 1.0);
        harness.check(t.getTranslateY(), 0.0);
        harness.check(t.getType() == 32);
    }
}

