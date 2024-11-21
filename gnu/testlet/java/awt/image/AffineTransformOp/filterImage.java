/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.AffineTransformOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class filterImage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testDefaults(harness);
    }

    private void testDefaults(TestHarness harness) {
        BufferedImage img = new BufferedImage(20, 20, 11);
        Graphics2D g = (Graphics2D)img.getGraphics();
        g.draw(new Line2D.Double(0.0, 0.0, 20.0, 20.0));
        AffineTransform xform = new AffineTransform();
        AffineTransformOp op = new AffineTransformOp(xform, 3);
        try {
            op.filter(img, img);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        BufferedImage dst = new BufferedImage(30, 40, 11);
        try {
            op.filter(img, dst);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        dst = new BufferedImage(20, 20, 2);
        try {
            op.filter(img, dst);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        dst = op.filter(img, null);
        harness.check(dst.getType(), op.createCompatibleDestImage(img, null).getType());
    }
}

