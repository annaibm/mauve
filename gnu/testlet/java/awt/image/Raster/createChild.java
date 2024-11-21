/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.Raster;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.awt.image.Raster.MyRaster;
import java.awt.Point;
import java.awt.image.Raster;
import java.awt.image.RasterFormatException;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;

public class createChild
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testData(harness);
        this.testBounds(harness);
        this.testBands(harness);
    }

    private void testData(TestHarness harness) {
        int b;
        int y;
        int x;
        Raster rst = this.createRaster(harness);
        Raster rst2 = rst.createChild(10, 20, 25, 15, 0, 0, null);
        harness.check(!(rst2 instanceof WritableRaster));
        harness.check(rst2.getMinX(), 0);
        harness.check(rst2.getMinY(), 0);
        harness.check(rst2.getWidth(), 25);
        harness.check(rst2.getHeight(), 15);
        for (x = 0; x < 25; ++x) {
            for (y = 0; y < 15; ++y) {
                for (b = 0; b < 3; ++b) {
                    harness.check(rst2.getSample(x, y, b), x + 10 + y + 20 + b);
                }
            }
        }
        rst2 = rst.createChild(10, 20, 25, 15, 30, 40, null);
        harness.check(rst2.getMinX(), 30);
        harness.check(rst2.getMinY(), 40);
        harness.check(rst2.getWidth(), 25);
        harness.check(rst2.getHeight(), 15);
        for (x = 30; x < 55; ++x) {
            for (y = 40; y < 55; ++y) {
                for (b = 0; b < 3; ++b) {
                    harness.check(rst2.getSample(x, y, b), x - 20 + y - 20 + b);
                }
            }
        }
    }

    private void testBounds(TestHarness harness) {
        Raster rst = this.createRaster(harness);
        try {
            rst.createChild(10, 20, 100, 100, 0, 0, null);
            harness.check(false);
        }
        catch (RasterFormatException ex) {
            harness.check(true);
        }
        catch (Exception ex) {
            harness.check(false);
        }
        try {
            Raster rst2 = rst.createChild(0, 0, 25, 25, 30, 30, null);
            rst2.createChild(10, 20, 10, 10, 0, 0, null);
            harness.check(false);
        }
        catch (RasterFormatException ex) {
            harness.check(true);
        }
        catch (Exception ex) {
            harness.check(false);
        }
    }

    private void testBands(TestHarness harness) {
        int b;
        int y;
        int x;
        Raster rst = this.createRaster(harness);
        Raster rst2 = rst.createChild(0, 0, 50, 40, 0, 0, null);
        harness.check(rst2.getNumBands(), rst.getNumBands());
        rst2 = rst.createChild(0, 0, 50, 40, 0, 0, new int[]{0, 1});
        harness.check(rst2.getNumBands(), 2);
        for (x = 0; x < 50; ++x) {
            for (y = 0; y < 40; ++y) {
                for (b = 0; b < 2; ++b) {
                    harness.check(rst2.getSample(x, y, b), x + y + b);
                }
            }
        }
        rst2 = rst.createChild(0, 0, 50, 40, 0, 0, new int[]{1, 2});
        harness.check(rst2.getNumBands(), 2);
        for (x = 0; x < 50; ++x) {
            for (y = 0; y < 40; ++y) {
                for (b = 0; b < 2; ++b) {
                    harness.check(rst2.getSample(x, y, b), x + y + b + 1);
                }
            }
        }
        rst2 = rst.createChild(0, 0, 50, 40, 0, 0, new int[]{1});
        harness.check(rst2.getNumBands(), 1);
        for (x = 0; x < 50; ++x) {
            for (y = 0; y < 40; ++y) {
                harness.check(rst2.getSample(x, y, 0), x + y + 1);
            }
        }
        rst2 = rst.createChild(0, 0, 50, 40, 0, 0, new int[]{2, 0});
        harness.check(rst2.getNumBands(), 2);
        for (x = 0; x < 50; ++x) {
            for (y = 0; y < 40; ++y) {
                harness.check(rst2.getSample(x, y, 0), x + y + 2);
                harness.check(rst2.getSample(x, y, 1), x + y);
            }
        }
    }

    private Raster createRaster(TestHarness harness) {
        WritableRaster rst = Raster.createWritableRaster(new SinglePixelPackedSampleModel(3, 50, 40, new int[]{0xFF0000, 65280, 255}), new Point(0, 0));
        for (int x = 0; x < 50; ++x) {
            for (int y = 0; y < 40; ++y) {
                for (int b = 0; b < 3; ++b) {
                    rst.setSample(x, y, b, x + y + b);
                }
            }
        }
        MyRaster rst2 = new MyRaster(rst.getSampleModel(), rst.getDataBuffer(), new Point(0, 0));
        harness.check(!(rst2 instanceof WritableRaster));
        return rst2;
    }
}

