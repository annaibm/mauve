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

public class setPixels
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
        this.testMethod3(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, int[], DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        int[] pixel = new int[18];
        ((SampleModel)m).getPixels(1, 2, 2, 3, pixel, db);
        harness.check(Arrays.equals(pixel, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        ((SampleModel)m).setPixels(1, 2, 2, 3, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, db);
        ((SampleModel)m).getPixels(1, 2, 2, 3, pixel, db);
        harness.check(Arrays.equals(pixel, new int[]{1, 2, 3, 4, 5, 2, 7, 0, 1, 2, 3, 0, 5, 6, 3, 0, 1, 2}));
        boolean pass = false;
        try {
            ((SampleModel)m).setPixels(1, 2, 2, 3, (int[])null, db);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ((SampleModel)m).setPixels(1, 2, 2, 3, pixel, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, float[], DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        float[] pixel = new float[18];
        m.getPixels(1, 2, 2, 3, pixel, db);
        harness.check(Arrays.equals(pixel, new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        m.setPixels(1, 2, 2, 3, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f, 13.0f, 14.0f, 15.0f, 16.0f, 17.0f, 18.0f}, db);
        m.getPixels(1, 2, 2, 3, pixel, db);
        harness.check(Arrays.equals(pixel, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 2.0f, 7.0f, 0.0f, 1.0f, 2.0f, 3.0f, 0.0f, 5.0f, 6.0f, 3.0f, 0.0f, 1.0f, 2.0f}));
        boolean pass = false;
        try {
            m.setPixels(1, 2, 2, 3, (float[])null, db);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setPixels(1, 2, 2, 3, pixel, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod3(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, double[], DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        double[] pixel = new double[18];
        m.getPixels(1, 2, 2, 3, pixel, db);
        harness.check(Arrays.equals(pixel, new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}));
        ((SampleModel)m).setPixels(1, 2, 2, 3, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, db);
        m.getPixels(1, 2, 2, 3, pixel, db);
        harness.check(Arrays.equals(pixel, new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 2.0, 7.0, 0.0, 1.0, 2.0, 3.0, 0.0, 5.0, 6.0, 3.0, 0.0, 1.0, 2.0}));
        boolean pass = false;
        try {
            m.setPixels(1, 2, 2, 3, (double[])null, db);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setPixels(1, 2, 2, 3, pixel, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

