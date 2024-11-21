/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.LookupOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;
import java.awt.image.MultiPixelPackedSampleModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class getBounds2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("(BufferedImage)");
        BufferedImage image = new BufferedImage(10, 20, 2);
        byte[] bytes = new byte[]{-86, -69};
        ByteLookupTable t = new ByteLookupTable(0, bytes);
        LookupOp op = new LookupOp(t, null);
        Rectangle2D bounds = op.getBounds2D(image);
        harness.check(bounds.getWidth(), 10.0);
        harness.check(bounds.getHeight(), 20.0);
        boolean pass = false;
        try {
            op.getBounds2D((BufferedImage)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(Raster)");
        byte[] bytes = new byte[]{-86, -69};
        ByteLookupTable t = new ByteLookupTable(0, bytes);
        LookupOp op = new LookupOp(t, null);
        WritableRaster raster = Raster.createWritableRaster(new MultiPixelPackedSampleModel(0, 10, 20, 8), null);
        Rectangle2D bounds = op.getBounds2D(raster);
        harness.check(bounds.getWidth(), 10.0);
        harness.check(bounds.getHeight(), 20.0);
        boolean pass = false;
        try {
            op.getBounds2D((Raster)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

