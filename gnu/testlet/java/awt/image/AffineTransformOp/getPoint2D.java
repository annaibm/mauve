/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.AffineTransformOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.image.AffineTransformOp;

public class getPoint2D
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
        harness.check(op.getPoint2D(new Point2D.Double(5.0, 5.0), null), new Point2D.Double(5.0, 5.0));
        Point2D pt = null;
        Point2D pt2 = op.getPoint2D(new Point2D.Double(10.0, -5.0), pt);
        harness.check(pt, null);
        harness.check(pt2, new Point2D.Double(10.0, -5.0));
        pt = new Point2D.Double(0.0, 0.0);
        pt2 = op.getPoint2D(new Point2D.Double(10.0, -5.0), pt);
        harness.check(pt, new Point2D.Double(10.0, -5.0));
        harness.check(pt, pt2);
        pt = new Point2D.Float(0.0f, 0.0f);
        op.getPoint2D(new Point2D.Float(-10.0f, -5.0f), pt);
        harness.check(pt, new Point2D.Float(-10.0f, -5.0f));
    }

    private void testRotation(TestHarness harness) {
        harness.checkPoint("testRotation");
        AffineTransform xform = AffineTransform.getRotateInstance(1.5707963267948966);
        AffineTransformOp op = new AffineTransformOp(xform, 3);
        harness.check(op.getPoint2D(new Point2D.Double(5.0, 5.0), null), new Point2D.Double(-5.0, 5.0));
        xform.rotate(1.0471975511965976);
        op = new AffineTransformOp(xform, 3);
        harness.check(op.getPoint2D(new Point2D.Double(5.0, 5.0), null), new Point2D.Double(-6.830127018922193, -1.8301270189221923));
        xform.setToIdentity();
        xform.rotate(1.5707963267948966, 10.0, 2.0);
        op = new AffineTransformOp(xform, 3);
        harness.check(op.getPoint2D(new Point2D.Double(5.0, 5.0), null), new Point2D.Double(7.0, -3.0));
    }

    private void testScale(TestHarness harness) {
        harness.checkPoint("testScale");
        AffineTransform xform = AffineTransform.getScaleInstance(1.0, 1.0);
        AffineTransformOp op = new AffineTransformOp(xform, 3);
        harness.check(op.getPoint2D(new Point2D.Double(5.0, 5.0), null), new Point2D.Double(5.0, 5.0));
        xform.scale(2.5, 4.75);
        op = new AffineTransformOp(xform, 3);
        harness.check(op.getPoint2D(new Point2D.Double(5.0, 5.0), null), new Point2D.Double(12.5, 23.75));
    }

    private void testShear(TestHarness harness) {
        harness.checkPoint("testShear");
        AffineTransform xform = AffineTransform.getShearInstance(1.5, 3.25);
        AffineTransformOp op = new AffineTransformOp(xform, 3);
        harness.check(op.getPoint2D(new Point2D.Double(5.0, 5.0), null), new Point2D.Double(12.5, 21.25));
    }

    private void testTranslation(TestHarness harness) {
        harness.checkPoint("testTranslation");
        AffineTransform xform = AffineTransform.getTranslateInstance(75.0, 50.0);
        AffineTransformOp op = new AffineTransformOp(xform, 3);
        harness.check(op.getPoint2D(new Point2D.Double(5.0, 5.0), null), new Point2D.Double(80.0, 55.0));
    }
}

