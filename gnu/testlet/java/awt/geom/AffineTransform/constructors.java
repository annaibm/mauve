/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
        this.testConstructor5(harness);
        this.testConstructor6(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("AffineTransform()");
        AffineTransform t = new AffineTransform();
        harness.check(t.getScaleX(), 1.0);
        harness.check(t.getScaleY(), 1.0);
        harness.check(t.getTranslateX(), 0.0);
        harness.check(t.getTranslateY(), 0.0);
        harness.check(t.getShearX(), 0.0);
        harness.check(t.getShearY(), 0.0);
        harness.check(t.getType() == 0);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("AffineTransform(AffineTransform)");
        AffineTransform t1 = new AffineTransform(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        AffineTransform t2 = new AffineTransform(t1);
        harness.check(t2.getScaleX(), 1.0);
        harness.check(t2.getScaleY(), 4.0);
        harness.check(t2.getTranslateX(), 5.0);
        harness.check(t2.getTranslateY(), 6.0);
        harness.check(t2.getShearX(), 3.0);
        harness.check(t2.getShearY(), 2.0);
        harness.check(t2.getType() == 32);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("AffineTransform(double[])");
        double[] d1 = new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        AffineTransform t1 = new AffineTransform(d1);
        harness.check(t1.getScaleX(), 1.0);
        harness.check(t1.getScaleY(), 4.0);
        harness.check(t1.getTranslateX(), 5.0);
        harness.check(t1.getTranslateY(), 6.0);
        harness.check(t1.getShearX(), 3.0);
        harness.check(t1.getShearY(), 2.0);
        harness.check(t1.getType() == 32);
        double[] d2 = new double[]{1.0, 2.0, 3.0, 4.0};
        AffineTransform t2 = new AffineTransform(d2);
        harness.check(t2.getScaleX(), 1.0);
        harness.check(t2.getScaleY(), 4.0);
        harness.check(t2.getTranslateX(), 0.0);
        harness.check(t2.getTranslateY(), 0.0);
        harness.check(t2.getShearX(), 3.0);
        harness.check(t2.getShearY(), 2.0);
        harness.check(t2.getType() == 32);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("AffineTransform(double, double, double, double, double, double)");
        AffineTransform t1 = new AffineTransform(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        harness.check(t1.getScaleX(), 1.0);
        harness.check(t1.getScaleY(), 4.0);
        harness.check(t1.getTranslateX(), 5.0);
        harness.check(t1.getTranslateY(), 6.0);
        harness.check(t1.getShearX(), 3.0);
        harness.check(t1.getShearY(), 2.0);
        harness.check(t1.getType() == 32);
    }

    private void testConstructor5(TestHarness harness) {
        harness.checkPoint("AffineTransform(float[])");
        float[] f1 = new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f};
        AffineTransform t1 = new AffineTransform(f1);
        harness.check(t1.getScaleX(), 1.0);
        harness.check(t1.getScaleY(), 4.0);
        harness.check(t1.getTranslateX(), 5.0);
        harness.check(t1.getTranslateY(), 6.0);
        harness.check(t1.getShearX(), 3.0);
        harness.check(t1.getShearY(), 2.0);
        harness.check(t1.getType() == 32);
        float[] d2 = new float[]{1.0f, 2.0f, 3.0f, 4.0f};
        AffineTransform t2 = new AffineTransform(d2);
        harness.check(t2.getScaleX(), 1.0);
        harness.check(t2.getScaleY(), 4.0);
        harness.check(t2.getTranslateX(), 0.0);
        harness.check(t2.getTranslateY(), 0.0);
        harness.check(t2.getShearX(), 3.0);
        harness.check(t2.getShearY(), 2.0);
        harness.check(t2.getType() == 32);
    }

    private void testConstructor6(TestHarness harness) {
        harness.checkPoint("AffineTransform(float, float, float, float, float, float)");
        AffineTransform t1 = new AffineTransform(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f);
        harness.check(t1.getScaleX(), 1.0);
        harness.check(t1.getScaleY(), 4.0);
        harness.check(t1.getTranslateX(), 5.0);
        harness.check(t1.getTranslateY(), 6.0);
        harness.check(t1.getShearX(), 3.0);
        harness.check(t1.getShearY(), 2.0);
        harness.check(t1.getType() == 32);
    }
}

