/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ColorConvertOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.ColorConvertOp;
import java.awt.image.DataBufferByte;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.util.Arrays;

public class createCompatibleDestRaster
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("createCompatibleDestRaster");
        this.simpleTest(harness);
        int[] models = new int[]{1000, 1001, 1003, 1004, 1002};
        for (int i = 0; i < models.length; ++i) {
            for (int j = 0; j < models.length; ++j) {
                this.colorModelTest(harness, models[i], models[j]);
            }
        }
        this.profileTest(harness, new ICC_Profile[]{ICC_Profile.getInstance(1004), ICC_Profile.getInstance(1001), ICC_Profile.getInstance(1000), ICC_Profile.getInstance(1003)});
        this.profileTest(harness, new ICC_Profile[]{ICC_Profile.getInstance(1003), ICC_Profile.getInstance(1000)});
        this.profileTest(harness, new ICC_Profile[]{ICC_Profile.getInstance(1003), ICC_Profile.getInstance(1001)});
    }

    private void simpleTest(TestHarness harness) {
        ColorConvertOp op = new ColorConvertOp(null);
        WritableRaster src = Raster.createBandedRaster(0, 10, 10, 3, new Point(5, 5));
        try {
            op.createCompatibleDestRaster(src);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        ColorSpace cs = ColorSpace.getInstance(1000);
        op = new ColorConvertOp(cs, null);
        try {
            op.createCompatibleDestRaster(src);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void colorModelTest(TestHarness harness, int cspace1, int cspace2) {
        WritableRaster dst;
        harness.checkPoint("two colorspaces defined, " + cspace1 + ", " + cspace2);
        ColorSpace cs = ColorSpace.getInstance(cspace1);
        ColorSpace cs2 = ColorSpace.getInstance(cspace2);
        ColorConvertOp op = new ColorConvertOp(cs, cs2, null);
        int bands = cs2.getNumComponents();
        WritableRaster src = Raster.createBandedRaster(3, 25, 40, bands, new Point(5, 5));
        try {
            dst = op.createCompatibleDestRaster(src);
            harness.check(dst.getHeight(), src.getHeight());
            harness.check(dst.getWidth(), src.getWidth());
            harness.check(dst.getNumBands(), bands);
            harness.check(dst.getTransferType(), 0);
            harness.check(dst.getDataBuffer().getDataType(), 0);
            harness.check(dst.getNumDataElements(), cs2.getNumComponents());
            harness.check(dst.getSampleModel() instanceof PixelInterleavedSampleModel);
            harness.check(dst.getDataBuffer() instanceof DataBufferByte);
            PixelInterleavedSampleModel sm = (PixelInterleavedSampleModel)dst.getSampleModel();
            harness.check(sm.getPixelStride(), cs2.getNumComponents());
            harness.check(sm.getScanlineStride(), cs2.getNumComponents() * src.getWidth());
            int[] expected = new int[cs2.getNumComponents()];
            for (int i = 0; i < expected.length; ++i) {
                expected[i] = i;
            }
            harness.check(Arrays.equals(sm.getBandOffsets(), expected));
            harness.check(dst.getDataBuffer().getNumBanks(), 1);
            harness.check(dst.getDataBuffer().getOffset(), 0);
            harness.check(dst.getDataBuffer().getSize(), src.getHeight() * src.getWidth() * cs2.getNumComponents());
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        src = Raster.createBandedRaster(1, 25, 40, bands, new Point(5, 5));
        try {
            dst = op.createCompatibleDestRaster(src);
            harness.check(dst.getNumBands(), bands);
            harness.check(dst.getTransferType(), 0);
            harness.check(dst.getDataBuffer().getDataType(), 0);
            harness.check(dst.getNumDataElements(), cs2.getNumComponents());
            harness.check(dst.getSampleModel() instanceof PixelInterleavedSampleModel);
            harness.check(dst.getDataBuffer() instanceof DataBufferByte);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        for (int i = 1; i < bands + 5; ++i) {
            src = Raster.createBandedRaster(3, 25, 40, i, new Point(5, 5));
            try {
                WritableRaster dst2 = op.createCompatibleDestRaster(src);
                harness.check(dst2.getNumBands(), cs2.getNumComponents());
                harness.check(dst2.getNumDataElements(), cs2.getNumComponents());
                continue;
            }
            catch (IllegalArgumentException e) {
                harness.check(false);
            }
        }
    }

    private void profileTest(TestHarness harness, ICC_Profile[] profiles) {
        harness.checkPoint("profile test, " + profiles[profiles.length - 1].getClass().getName());
        ColorConvertOp op = new ColorConvertOp(profiles, null);
        WritableRaster src = Raster.createBandedRaster(3, 25, 40, 5, new Point(5, 5));
        try {
            WritableRaster dst = op.createCompatibleDestRaster(src);
            harness.check(dst.getHeight(), src.getHeight());
            harness.check(dst.getWidth(), src.getWidth());
            harness.check(dst.getTransferType(), 0);
            harness.check(dst.getDataBuffer().getDataType(), 0);
            if (profiles[profiles.length - 1].getColorSpaceType() == 6) {
                harness.check(dst.getNumBands(), 1);
                harness.check(dst.getNumDataElements(), 1);
            } else {
                harness.check(dst.getNumBands(), 3);
                harness.check(dst.getNumDataElements(), 3);
            }
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        for (int i = 1; i < 5; ++i) {
            src = Raster.createBandedRaster(3, 25, 40, i, new Point(5, 5));
            try {
                WritableRaster dst = op.createCompatibleDestRaster(src);
                harness.check(dst.getTransferType(), 0);
                harness.check(dst.getDataBuffer().getDataType(), 0);
                if (profiles[profiles.length - 1].getColorSpaceType() == 6) {
                    harness.check(dst.getNumBands(), 1);
                    harness.check(dst.getNumDataElements(), 1);
                    continue;
                }
                harness.check(dst.getNumBands(), 3);
                harness.check(dst.getNumDataElements(), 3);
                continue;
            }
            catch (IllegalArgumentException e) {
                harness.check(false);
            }
        }
    }
}

