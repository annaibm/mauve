/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.LookupOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;
import java.awt.image.MultiPixelPackedSampleModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class createCompatibleDestRaster
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        byte[] bytes = new byte[]{-86, -69};
        ByteLookupTable t = new ByteLookupTable(0, bytes);
        LookupOp op = new LookupOp(t, null);
        WritableRaster raster = Raster.createWritableRaster(new MultiPixelPackedSampleModel(0, 10, 20, 8), null);
        WritableRaster dest = op.createCompatibleDestRaster(raster);
        harness.check(dest.getWidth(), 10);
        harness.check(dest.getHeight(), 20);
        harness.check(dest.getNumBands(), 1);
        harness.check(dest.getSampleModel() instanceof MultiPixelPackedSampleModel);
        harness.check(dest.getTransferType(), raster.getTransferType());
        harness.check(dest.getDataBuffer().getDataType(), raster.getDataBuffer().getDataType());
        harness.check(dest.getNumDataElements(), raster.getNumDataElements());
        boolean pass = false;
        try {
            op.createCompatibleDestRaster(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        raster = Raster.createBandedRaster(0, 25, 40, 3, new Point(5, 5));
        WritableRaster dst = op.createCompatibleDestRaster(raster);
        harness.check(dst.getNumBands(), raster.getNumBands());
        harness.check(dst.getTransferType(), raster.getTransferType());
        harness.check(dst.getDataBuffer().getDataType(), raster.getDataBuffer().getDataType());
        harness.check(dst.getNumDataElements(), raster.getNumDataElements());
        raster = Raster.createBandedRaster(3, 25, 40, 5, new Point(5, 5));
        dst = op.createCompatibleDestRaster(raster);
        harness.check(dst.getNumBands(), raster.getNumBands());
        harness.check(dst.getTransferType(), raster.getTransferType());
        harness.check(dst.getDataBuffer().getDataType(), raster.getDataBuffer().getDataType());
        harness.check(dst.getNumDataElements(), raster.getNumDataElements());
    }
}

