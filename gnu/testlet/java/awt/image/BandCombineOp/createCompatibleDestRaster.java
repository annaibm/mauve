/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandCombineOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.image.BandCombineOp;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class createCompatibleDestRaster
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.basicTest(harness);
        this.test2(harness);
        this.test3(harness);
        this.impossibleTest(harness);
    }

    private void basicTest(TestHarness harness) {
        WritableRaster dst;
        harness.checkPoint("createCompatibleDestRaster");
        float[][] matrix = new float[][]{{1.0f, 2.0f, 3.0f}, {4.0f, 5.0f, 6.0f}, {7.0f, 8.0f, 9.0f}};
        WritableRaster src = Raster.createBandedRaster(3, 25, 40, 3, new Point(5, 5));
        BandCombineOp op = new BandCombineOp(matrix, null);
        try {
            dst = op.createCompatibleDestRaster(src);
            harness.check(dst.getNumBands(), 3);
            harness.check(dst.getHeight(), src.getHeight());
            harness.check(dst.getWidth(), src.getWidth());
            harness.check(dst.getTransferType(), src.getTransferType());
            harness.check(dst.getDataBuffer().getDataType(), src.getDataBuffer().getDataType());
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        src = Raster.createBandedRaster(0, 25, 40, 3, new Point(5, 5));
        try {
            dst = op.createCompatibleDestRaster(src);
            harness.check(dst.getTransferType(), src.getTransferType());
            harness.check(dst.getDataBuffer().getDataType(), src.getDataBuffer().getDataType());
            harness.check(dst.getNumBands(), 3);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        src = Raster.createBandedRaster(3, 25, 40, 4, new Point(5, 5));
        try {
            op.createCompatibleDestRaster(src);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        src = Raster.createBandedRaster(3, 25, 40, 1, new Point(5, 5));
        try {
            op.createCompatibleDestRaster(src);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void test2(TestHarness harness) {
        float[][] matrix = new float[][]{{1.0f, 2.0f, 3.0f, 1.0f}, {4.0f, 5.0f, 6.0f, 1.0f}, {7.0f, 8.0f, 9.0f, 1.0f}};
        BandCombineOp op = new BandCombineOp(matrix, null);
        WritableRaster src = Raster.createBandedRaster(3, 25, 40, 3, new Point(5, 5));
        try {
            WritableRaster dst = op.createCompatibleDestRaster(src);
            harness.check(dst.getNumBands(), 3);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        src = Raster.createBandedRaster(3, 25, 40, 4, new Point(5, 5));
        try {
            op.createCompatibleDestRaster(src);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        src = Raster.createBandedRaster(3, 25, 40, 2, new Point(5, 5));
        try {
            op.createCompatibleDestRaster(src);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        src = Raster.createBandedRaster(3, 25, 40, 5, new Point(5, 5));
        try {
            op.createCompatibleDestRaster(src);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void test3(TestHarness harness) {
        float[][] matrix = new float[][]{{1.0f, 2.0f, 3.0f, 1.0f, 5.0f}, {4.0f, 5.0f, 6.0f, 1.0f, 5.0f}, {7.0f, 8.0f, 9.0f, 1.0f, 5.0f}, {1.0f, 2.0f, 3.0f, 4.0f, 5.0f}};
        BandCombineOp op = new BandCombineOp(matrix, null);
        WritableRaster src = Raster.createBandedRaster(3, 25, 40, 4, new Point(5, 5));
        try {
            WritableRaster dst = op.createCompatibleDestRaster(src);
            harness.check(dst.getNumBands(), 4);
        }
        catch (IllegalArgumentException e) {
            harness.check(false);
        }
        src = Raster.createBandedRaster(3, 25, 40, 5, new Point(5, 5));
        try {
            op.createCompatibleDestRaster(src);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        src = Raster.createBandedRaster(3, 25, 40, 3, new Point(5, 5));
        try {
            op.createCompatibleDestRaster(src);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        src = Raster.createBandedRaster(3, 25, 40, 6, new Point(5, 5));
        try {
            op.createCompatibleDestRaster(src);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }

    private void impossibleTest(TestHarness harness) {
        WritableRaster src;
        int i;
        float[][] matrix = new float[][]{{1.0f, 2.0f, 3.0f, 1.0f, 5.0f}, {4.0f, 5.0f, 6.0f, 1.0f, 5.0f}, {7.0f, 8.0f, 9.0f, 1.0f, 5.0f}};
        BandCombineOp op = new BandCombineOp(matrix, null);
        for (i = 2; i < 6; ++i) {
            src = Raster.createBandedRaster(3, 25, 40, i, new Point(5, 5));
            try {
                op.createCompatibleDestRaster(src);
                harness.check(false);
                continue;
            }
            catch (IllegalArgumentException e) {
                harness.check(true);
            }
        }
        matrix = new float[][]{{1.0f, 2.0f, 3.0f}, {4.0f, 5.0f, 6.0f}, {2.0f, 4.0f, 6.0f}, {1.0f, 3.0f, 5.0f}, {7.0f, 8.0f, 9.0f}};
        op = new BandCombineOp(matrix, null);
        for (i = 2; i < 6; ++i) {
            src = Raster.createBandedRaster(3, 25, 40, i, new Point(5, 5));
            try {
                op.createCompatibleDestRaster(src);
                harness.check(false);
                continue;
            }
            catch (IllegalArgumentException e) {
                harness.check(true);
            }
        }
    }
}

