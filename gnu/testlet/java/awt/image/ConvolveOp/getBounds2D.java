/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ConvolveOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class getBounds2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("(Raster)");
        Kernel k1 = new Kernel(3, 3, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f});
        ConvolveOp op = new ConvolveOp(k1, 1, null);
        WritableRaster r = Raster.createBandedRaster(0, 4, 30, 3, null);
        Rectangle2D bounds = op.getBounds2D(r);
        harness.check(bounds, new Rectangle(0, 0, 4, 30));
        boolean pass = false;
        try {
            op.getBounds2D((Raster)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(BufferedImage)");
        Kernel k1 = new Kernel(3, 3, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f});
        ConvolveOp op = new ConvolveOp(k1, 1, null);
        BufferedImage image = new BufferedImage(5, 10, 10);
        Rectangle2D bounds = op.getBounds2D(image);
        harness.check(bounds, new Rectangle(0, 0, 5, 10));
        boolean pass = false;
        try {
            op.getBounds2D((BufferedImage)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

