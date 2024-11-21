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

public class getBounds2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getBounds2D");
        float[][] matrix = new float[][]{{2.0f, 7.0f}};
        WritableRaster src = Raster.createBandedRaster(3, 5, 5, 1, new Point(0, 0));
        BandCombineOp op = new BandCombineOp(matrix, null);
        harness.check(op.getBounds2D(src), src.getBounds());
    }
}

