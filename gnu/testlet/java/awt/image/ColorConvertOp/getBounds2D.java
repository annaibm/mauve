/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ColorConvertOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.color.ColorSpace;
import java.awt.image.ColorConvertOp;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class getBounds2D
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getBounds2D");
        WritableRaster src = Raster.createBandedRaster(3, 5, 5, 1, new Point(0, 0));
        ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(1000), null);
        harness.check(op.getBounds2D(src), src.getBounds());
    }
}

