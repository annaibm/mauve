/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.AffineTransformOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class createCompatibleDestRaster
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        WritableRaster dst;
        harness.checkPoint("createCompatibleDestRaster");
        WritableRaster src = Raster.createBandedRaster(3, 25, 40, 3, new Point(5, 5));
        AffineTransform xform = new AffineTransform();
        AffineTransformOp op = new AffineTransformOp(xform, 2);
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

