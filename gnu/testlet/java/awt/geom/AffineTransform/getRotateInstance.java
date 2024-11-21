/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;

public class getRotateInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t = AffineTransform.getRotateInstance(0.5);
        harness.check(t.getScaleX(), Math.cos(0.5));
        harness.check(t.getShearX(), -Math.sin(0.5));
        harness.check(t.getTranslateX(), 0.0);
        harness.check(t.getShearY(), Math.sin(0.5));
        harness.check(t.getScaleY(), Math.cos(0.5));
        harness.check(t.getTranslateY(), 0.0);
        harness.check(t.getType() == 16);
        t = AffineTransform.getRotateInstance(0.5, 1.0, 2.0);
        harness.check(t.getScaleX(), Math.cos(0.5));
        harness.check(t.getShearX(), -Math.sin(0.5));
        harness.check(t.getTranslateX(), 1.0 - 1.0 * Math.cos(0.5) + 2.0 * Math.sin(0.5));
        harness.check(t.getShearY(), Math.sin(0.5));
        harness.check(t.getScaleY(), Math.cos(0.5));
        harness.check(t.getTranslateY(), 2.0 - 1.0 * Math.sin(0.5) - 2.0 * Math.cos(0.5));
        harness.check(t.getType() == 17);
    }
}

