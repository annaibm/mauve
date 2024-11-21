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
import java.util.Arrays;

public class filter
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("filter");
        float[][] matrix = new float[][]{{2.0f, 7.0f}, {5.0f, 6.0f}};
        WritableRaster src = Raster.createBandedRaster(3, 5, 5, 2, new Point(0, 0));
        src.setSample(2, 1, 0, 150);
        src.setSample(4, 4, 0, 85);
        src.setSample(2, 1, 1, 25);
        src.setSample(4, 4, 1, 110);
        BandCombineOp op = new BandCombineOp(matrix, null);
        WritableRaster dst2 = op.createCompatibleDestRaster(src);
        WritableRaster dst = op.filter(src, dst2);
        harness.check(dst, dst2);
        harness.check(dst.getNumBands(), 2);
        dst2 = null;
        dst = op.filter(src, dst2);
        harness.check(dst instanceof WritableRaster);
        harness.check(dst2, null);
        int[] pixels = dst.getSamples(0, 0, 5, 5, 0, (int[])null);
        int[] expected = new int[25];
        Arrays.fill(expected, 0);
        expected[7] = 475;
        expected[24] = 940;
        harness.check(Arrays.equals(expected, pixels));
        pixels = dst.getSamples(0, 0, 5, 5, 1, pixels);
        expected[7] = 900;
        expected[24] = 1085;
        harness.check(Arrays.equals(expected, pixels));
        matrix = new float[][]{{2.0f, -7.0f, 5.0f}, {5.0f, 6.0f, -3.0f}};
        op = new BandCombineOp(matrix, null);
        dst = op.filter(src, dst);
        pixels = dst.getSamples(0, 0, 5, 5, 0, (int[])null);
        Arrays.fill(expected, 5);
        expected[7] = 130;
        expected[24] = -595;
        harness.check(Arrays.equals(expected, pixels));
        pixels = dst.getSamples(0, 0, 5, 5, 1, (int[])null);
        Arrays.fill(expected, -3);
        expected[7] = 897;
        expected[24] = 1082;
        harness.check(Arrays.equals(expected, pixels));
        matrix = new float[][]{{2.0E9f, 2.0E9f}, {2.0E9f, 2.0E9f}};
        try {
            op = new BandCombineOp(matrix, null);
            dst = op.filter(src, dst);
            harness.check(true);
        }
        catch (Exception e) {
            harness.check(false);
        }
        try {
            expected[25] = 100;
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            pixels = dst.getSamples(0, 0, 5, 5, 2, pixels);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        dst = Raster.createBandedRaster(3, 5, 5, 6, new Point(0, 0));
        try {
            dst = op.filter(src, dst);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        dst = Raster.createBandedRaster(0, 5, 5, 1, new Point(0, 0));
        try {
            dst = op.filter(src, dst);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }
}

