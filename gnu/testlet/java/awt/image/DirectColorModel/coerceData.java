/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DirectColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Point;
import java.awt.image.BandedSampleModel;
import java.awt.image.ColorModel;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;

public class coerceData
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("coerceData with BandedSampleModel");
        this.runTest(harness, new BandedSampleModel(3, 50, 50, 4));
        harness.checkPoint("coerceData with ComponentSampleModel");
        this.runTest(harness, new ComponentSampleModel(3, 50, 50, 4, 200, new int[]{0, 1, 2, 3}));
        harness.checkPoint("coerceData with PixelInterleavedSampleModel");
        this.runTest(harness, new PixelInterleavedSampleModel(3, 50, 50, 4, 200, new int[]{0, 1, 2, 3}));
        harness.checkPoint("coerceData with SinglePixelPackedSampleModel");
        this.runTest(harness, new SinglePixelPackedSampleModel(3, 50, 50, new int[]{0xFF0000, 65280, 255, -16777216}));
    }

    private void runTest(TestHarness harness, SampleModel sample) {
        int b;
        int y;
        int x;
        WritableRaster rast = Raster.createWritableRaster(sample, new Point(0, 0));
        for (int x2 = 0; x2 < 50; ++x2) {
            for (int y2 = 0; y2 < 50; ++y2) {
                for (int b2 = 0; b2 < 4; ++b2) {
                    if (b2 < 3) {
                        rast.setSample(x2, y2, b2, (float)x2 + (float)y2 + (float)b2);
                        continue;
                    }
                    rast.setSample(x2, y2, b2, (float)(x2 + y2));
                }
            }
        }
        DirectColorModel dcm = new DirectColorModel(32, 0xFF0000, 65280, 255, -16777216);
        harness.check(dcm.isAlphaPremultiplied(), false);
        ColorModel resultCM = dcm.coerceData(rast, false);
        harness.check(resultCM.getClass().equals(dcm.getClass()));
        harness.check(resultCM.isAlphaPremultiplied(), false);
        harness.check(dcm, resultCM);
        for (x = 0; x < 50; ++x) {
            for (y = 0; y < 50; ++y) {
                for (b = 0; b < 4; ++b) {
                    if (b < 3) {
                        harness.check(rast.getSample(x, y, b), x + y + b);
                        continue;
                    }
                    harness.check(rast.getSampleFloat(x, y, b), (double)(x + y));
                }
            }
        }
        resultCM = dcm.coerceData(rast, true);
        harness.check(resultCM.getClass().equals(dcm.getClass()));
        harness.check(resultCM.isAlphaPremultiplied(), true);
        harness.check(dcm != resultCM);
        for (x = 0; x < 50; ++x) {
            for (y = 0; y < 50; ++y) {
                for (b = 0; b < 4; ++b) {
                    if (b < 3) {
                        harness.check(rast.getSample(x, y, b), Math.round((float)(x + y + b) * ((float)(x + y) / 255.0f)));
                        continue;
                    }
                    harness.check(rast.getSampleFloat(x, y, b), (double)(x + y));
                }
            }
        }
        WritableRaster rast2 = Raster.createWritableRaster(sample, new Point(0, 0));
        for (int x3 = 0; x3 < 50; ++x3) {
            for (int y3 = 0; y3 < 50; ++y3) {
                for (int b3 = 0; b3 < 4; ++b3) {
                    rast2.setSample(x3, y3, b3, rast.getSample(x3, y3, b3));
                }
            }
        }
        harness.check(resultCM.isAlphaPremultiplied(), true);
        ColorModel resultCM2 = resultCM.coerceData(rast, false);
        harness.check(resultCM2.getClass().equals(resultCM.getClass()));
        harness.check(resultCM2.isAlphaPremultiplied(), false);
        harness.check(resultCM != resultCM2);
        for (int x4 = 0; x4 < 50; ++x4) {
            for (int y4 = 0; y4 < 50; ++y4) {
                for (int b4 = 0; b4 < 4; ++b4) {
                    if (b4 < 3) {
                        float expected = (float)rast2.getSample(x4, y4, b4) / ((float)(x4 + y4) / 255.0f);
                        if ((double)(expected - (float)((int)expected)) > 0.49 && (double)(expected - (float)((int)expected)) < 0.51) {
                            harness.check(rast.getSample(x4, y4, b4) == (int)expected || rast.getSample(x4, y4, b4) == (int)expected + 1);
                            continue;
                        }
                        harness.check(rast.getSample(x4, y4, b4), Math.round(expected));
                        continue;
                    }
                    harness.check(rast.getSampleFloat(x4, y4, b4), (double)(x4 + y4));
                }
            }
        }
    }
}

