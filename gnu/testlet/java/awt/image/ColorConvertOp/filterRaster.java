/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ColorConvertOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.WritableRaster;

public class filterRaster
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("filter(Raster)");
        BufferedImage img = new BufferedImage(20, 20, 1);
        Graphics2D g = (Graphics2D)img.getGraphics();
        g.draw(new Line2D.Double(0.0, 0.0, 20.0, 20.0));
        ColorSpace cs1 = ColorSpace.getInstance(1000);
        ColorSpace cs2 = ColorSpace.getInstance(1003);
        ColorConvertOp op = new ColorConvertOp(cs1, cs2, null);
        WritableRaster raster = img.getRaster();
        try {
            op.filter(raster, raster);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        BufferedImage dst = new BufferedImage(30, 40, 10);
        WritableRaster raster2 = dst.getRaster();
        try {
            op.filter(raster, raster2);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        WritableRaster dstRaster = op.filter(raster, null);
        harness.check(dstRaster.getTransferType(), op.createCompatibleDestRaster(raster).getTransferType());
        harness.check(dstRaster.getNumBands(), op.createCompatibleDestRaster(raster).getNumBands());
        harness.check(dstRaster.getNumDataElements(), op.createCompatibleDestRaster(raster).getNumDataElements());
        op = new ColorConvertOp(null);
        try {
            op.filter(raster, null);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        op = new ColorConvertOp(cs1, null);
        try {
            op.filter(raster, null);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        op = new ColorConvertOp(cs1, cs2, null);
        dstRaster = new BufferedImage(20, 20, 2).getRaster();
        try {
            op.filter(raster, dstRaster);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        raster = new BufferedImage(20, 20, 10).getRaster();
        try {
            op.filter(raster, raster2);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }
}

