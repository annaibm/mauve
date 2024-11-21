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
import java.awt.image.ImagingOpException;
import java.awt.image.WritableRaster;

public class filterRaster
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testDefaults(harness, 2);
        this.testDefaults(harness, 3);
        this.testDefaults(harness, 1);
    }

    private void testDefaults(TestHarness harness, int type) {
        BufferedImage img = new BufferedImage(20, 20, 11);
        Graphics2D g = (Graphics2D)img.getGraphics();
        g.draw(new Line2D.Double(0.0, 0.0, 20.0, 20.0));
        WritableRaster src = img.getRaster();
        AffineTransform xform = new AffineTransform();
        AffineTransformOp op = new AffineTransformOp(xform, type);
        WritableRaster dest = src.createCompatibleWritableRaster();
        try {
            op.filter(src, dest);
            harness.check(true);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        try {
            op.filter(src, src);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        dest = src.createCompatibleWritableRaster(75, 87);
        try {
            op.filter(src, dest);
            harness.check(true);
        }
        catch (ImagingOpException e) {
            harness.check(false);
        }
        WritableRaster dest2 = op.filter(src, null);
        harness.check(dest2 != null);
    }
}

