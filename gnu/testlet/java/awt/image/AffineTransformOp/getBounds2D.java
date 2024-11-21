/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.AffineTransformOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class getBounds2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testIdentity(harness);
        this.testRotation(harness);
        this.testScale(harness);
        this.testShear(harness);
        this.testTranslation(harness);
    }

    private void testIdentity(TestHarness harness) {
        harness.checkPoint("testIdentity");
        AffineTransform xform = new AffineTransform();
        AffineTransformOp op = new AffineTransformOp(xform, 3);
        BufferedImage img = new BufferedImage(30, 40, 1);
        harness.check(op.getBounds2D(img), new Rectangle2D.Float(0.0f, 0.0f, 30.0f, 40.0f));
    }

    private void testRotation(TestHarness harness) {
        harness.checkPoint("testRotation");
        AffineTransform xform = AffineTransform.getRotateInstance(1.5707963267948966);
        AffineTransformOp op = new AffineTransformOp(xform, 3);
        BufferedImage img = new BufferedImage(30, 40, 1);
        harness.check(op.getBounds2D(img), new Rectangle2D.Float(-40.0f, 0.0f, 40.0f, 30.0f));
        xform.rotate(1.0471975511965976);
        op = new AffineTransformOp(xform, 3);
        harness.check(op.getBounds2D(img), new Rectangle2D.Float(-45.980762f, -34.641018f, 45.980762f, 49.641018f));
        xform.setToIdentity();
        xform.rotate(1.5707963267948966, 10.0, 15.0);
        op = new AffineTransformOp(xform, 3);
        harness.check(op.getBounds2D(img), new Rectangle2D.Float(-15.0f, 5.0f, 40.0f, 30.0f));
    }

    private void testScale(TestHarness harness) {
        harness.checkPoint("testScale");
        AffineTransform xform = AffineTransform.getScaleInstance(1.0, 1.0);
        BufferedImage img = new BufferedImage(30, 40, 1);
        AffineTransformOp op = new AffineTransformOp(xform, 3);
        harness.check(op.getBounds2D(img), new Rectangle2D.Float(0.0f, 0.0f, 30.0f, 40.0f));
        xform.scale(2.5, 4.75);
        op = new AffineTransformOp(xform, 3);
        harness.check(op.getBounds2D(img), new Rectangle2D.Float(0.0f, 0.0f, 75.0f, 190.0f));
    }

    private void testShear(TestHarness harness) {
        harness.checkPoint("testHarness");
        AffineTransform xform = AffineTransform.getShearInstance(1.5, 3.25);
        BufferedImage img = new BufferedImage(30, 40, 1);
        AffineTransformOp op = new AffineTransformOp(xform, 3);
        harness.check(op.getBounds2D(img), new Rectangle2D.Float(0.0f, 0.0f, 90.0f, 137.5f));
    }

    private void testTranslation(TestHarness harness) {
        harness.checkPoint("testTranslation");
        AffineTransform xform = AffineTransform.getTranslateInstance(75.0, 50.0);
        BufferedImage img = new BufferedImage(30, 40, 1);
        AffineTransformOp op = new AffineTransformOp(xform, 3);
        harness.check(op.getBounds2D(img), new Rectangle2D.Float(75.0f, 50.0f, 30.0f, 40.0f));
    }
}

