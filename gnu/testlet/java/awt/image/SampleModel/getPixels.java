/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.MultiPixelPackedSampleModel;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.util.Arrays;

public class getPixels
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
        this.testMethod3(harness);
        this.testMethod1MultiPixelPackedSampleModel(harness);
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
        pixel = ((SampleModel)m).getPixels(1, 2, 2, 3, (int[])null, db);
        harness.check(Arrays.equals(pixel, new int[]{1, 2, 3, 4, 5, 2, 7, 0, 1, 2, 3, 0, 5, 6, 3, 0, 1, 2}));
        boolean pass = false;
        try {
            ((SampleModel)m).getPixels(1, 2, 2, 3, pixel, (DataBuffer)null);
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
        ((SampleModel)m).setPixels(1, 2, 2, 3, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, db);
        m.getPixels(1, 2, 2, 3, pixel, db);
        harness.check(Arrays.equals(pixel, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 2.0f, 7.0f, 0.0f, 1.0f, 2.0f, 3.0f, 0.0f, 5.0f, 6.0f, 3.0f, 0.0f, 1.0f, 2.0f}));
        pixel = m.getPixels(1, 2, 2, 3, (float[])null, db);
        harness.check(Arrays.equals(pixel, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 2.0f, 7.0f, 0.0f, 1.0f, 2.0f, 3.0f, 0.0f, 5.0f, 6.0f, 3.0f, 0.0f, 1.0f, 2.0f}));
        boolean pass = false;
        try {
            m.getPixels(1, 2, 2, 3, pixel, (DataBuffer)null);
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
        m.setPixels(1, 2, 2, 3, new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0}, db);
        m.getPixels(1, 2, 2, 3, pixel, db);
        harness.check(Arrays.equals(pixel, new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 2.0, 7.0, 0.0, 1.0, 2.0, 3.0, 0.0, 5.0, 6.0, 3.0, 0.0, 1.0, 2.0}));
        pixel = m.getPixels(1, 2, 2, 3, (double[])null, db);
        harness.check(Arrays.equals(pixel, new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 2.0, 7.0, 0.0, 1.0, 2.0, 3.0, 0.0, 5.0, 6.0, 3.0, 0.0, 1.0, 2.0}));
        boolean pass = false;
        try {
            m.getPixels(1, 2, 2, 3, pixel, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod1MultiPixelPackedSampleModel(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, int[], DataBuffer)");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(0, 10, 20, 2);
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        int[] pixel = new int[6];
        m.getPixels(1, 2, 2, 3, pixel, db);
        harness.check(Arrays.equals(pixel, new int[]{0, 0, 0, 0, 0, 0}));
        db.setElem(6, 24);
        db.setElem(9, 48);
        db.setElem(12, 28);
        m.getPixels(1, 2, 2, 3, pixel, db);
        harness.check(Arrays.equals(pixel, new int[]{1, 2, 3, 0, 1, 3}));
        pixel = m.getPixels(1, 2, 2, 3, (int[])null, db);
        harness.check(Arrays.equals(pixel, new int[]{1, 2, 3, 0, 1, 3}));
        boolean pass = false;
        try {
            m.getPixels(1, 2, 2, 3, pixel, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

