/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.util.Arrays;

public class setPixel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
        this.testMethod3(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("(int, int, int[], DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        int[] pixel = new int[3];
        ((SampleModel)m).getPixel(1, 2, pixel, db);
        harness.check(Arrays.equals(pixel, new int[]{0, 0, 0}));
        ((SampleModel)m).setPixel(1, 2, new int[]{1, 2, 3}, db);
        ((SampleModel)m).getPixel(1, 2, pixel, db);
        harness.check(Arrays.equals(pixel, new int[]{1, 2, 3}));
        boolean pass = true;
        try {
            ((SampleModel)m).setPixel(1, 2, (int[])null, db);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ((SampleModel)m).setPixel(1, 2, pixel, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int, int, float[], DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        float[] pixel = new float[3];
        m.getPixel(1, 2, pixel, db);
        harness.check(Arrays.equals(pixel, new float[]{0.0f, 0.0f, 0.0f}));
        m.setPixel(1, 2, new float[]{1.0f, 2.0f, 3.0f}, db);
        m.getPixel(1, 2, pixel, db);
        harness.check(Arrays.equals(pixel, new float[]{1.0f, 2.0f, 3.0f}));
        boolean pass = true;
        try {
            m.setPixel(1, 2, (float[])null, db);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setPixel(1, 2, pixel, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod3(TestHarness harness) {
        harness.checkPoint("(int, int, double[], DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        double[] pixel = new double[3];
        m.getPixel(1, 2, pixel, db);
        harness.check(Arrays.equals(pixel, new double[]{0.0, 0.0, 0.0}));
        m.setPixel(1, 2, new double[]{1.0, 2.0, 3.0}, db);
        m.getPixel(1, 2, pixel, db);
        harness.check(Arrays.equals(pixel, new double[]{1.0, 2.0, 3.0}));
        boolean pass = true;
        try {
            m.setPixel(1, 2, (double[])null, db);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setPixel(1, 2, pixel, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

