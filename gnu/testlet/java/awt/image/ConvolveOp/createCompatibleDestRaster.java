/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ConvolveOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class createCompatibleDestRaster
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        WritableRaster dst;
        harness.checkPoint("createCompatibleDestRaster");
        WritableRaster src = Raster.createBandedRaster(3, 25, 40, 3, new Point(5, 5));
        Kernel kern = new Kernel(3, 3, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f});
        ConvolveOp op = new ConvolveOp(kern, 1, null);
        try {
            dst = op.createCompatibleDestRaster(src);
            harness.check(dst.getHeight(), src.getHeight());
            harness.check(dst.getWidth(), src.getWidth());
            harness.check(dst.getNumBands(), src.getNumBands());
            harness.check(dst.getTransferType(), src.getTransferType());
            harness.check(dst.getDataBuffer().getDataType(), src.getDataBuffer().getDataType());
            harness.check(dst.getNumDataElements(), src.getNumDataElements());
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        src = Raster.createBandedRaster(0, 25, 40, 3, new Point(5, 5));
        try {
            dst = op.createCompatibleDestRaster(src);
            harness.check(dst.getNumBands(), src.getNumBands());
            harness.check(dst.getTransferType(), src.getTransferType());
            harness.check(dst.getDataBuffer().getDataType(), src.getDataBuffer().getDataType());
            harness.check(dst.getNumDataElements(), src.getNumDataElements());
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        src = Raster.createBandedRaster(3, 25, 40, 5, new Point(5, 5));
        try {
            dst = op.createCompatibleDestRaster(src);
            harness.check(dst.getNumBands(), src.getNumBands());
            harness.check(dst.getTransferType(), src.getTransferType());
            harness.check(dst.getDataBuffer().getDataType(), src.getDataBuffer().getDataType());
            harness.check(dst.getNumDataElements(), src.getNumDataElements());
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
    }
}

