/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;

public class getTranslateInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t = AffineTransform.getTranslateInstance(1.0, 2.0);
        harness.check(t.getScaleX(), 1.0);
        harness.check(t.getShearX(), 0.0);
        harness.check(t.getTranslateX(), 1.0);
        harness.check(t.getShearY(), 0.0);
        harness.check(t.getScaleY(), 1.0);
        harness.check(t.getTranslateY(), 2.0);
        harness.check(t.getType() == 1);
    }
}

