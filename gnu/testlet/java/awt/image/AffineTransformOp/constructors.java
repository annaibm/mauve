/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.AffineTransformOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.ImagingOpException;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("(xform, interpolationType)");
        AffineTransform xform = new AffineTransform();
        AffineTransformOp op = new AffineTransformOp(xform, 3);
        harness.check(op.getTransform(), xform);
        harness.check(op.getInterpolationType(), 3);
        harness.check(op.getRenderingHints(), new RenderingHints(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC));
        op = new AffineTransformOp(xform, 2);
        harness.check(op.getTransform(), xform);
        harness.check(op.getInterpolationType(), 2);
        harness.check(op.getRenderingHints(), new RenderingHints(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR));
        op = new AffineTransformOp(xform, 1);
        harness.check(op.getTransform(), xform);
        harness.check(op.getInterpolationType(), 1);
        harness.check(op.getRenderingHints(), new RenderingHints(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR));
        xform = new AffineTransform(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        try {
            new AffineTransformOp(xform, 3);
            harness.check(false);
        }
        catch (ImagingOpException e) {
            harness.check(true);
        }
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(xform, hints)");
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        AffineTransform xform = new AffineTransform();
        AffineTransformOp op = new AffineTransformOp(xform, hints);
        harness.check(op.getTransform(), xform);
        harness.check(op.getRenderingHints(), hints);
        xform = new AffineTransform(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        try {
            new AffineTransformOp(xform, hints);
            harness.check(false);
        }
        catch (ImagingOpException e) {
            harness.check(true);
        }
    }
}

