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

public class getPixel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
        this.testMethod3(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("(int, int, int[], DataBuffer)");
        SampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = m.createDataBuffer();
        int[] pixel = new int[3];
        m.getPixel(1, 2, pixel, db);
        harness.check(Arrays.equals(pixel, new int[]{0, 0, 0}));
        m.setPixel(1, 2, new int[]{1, 2, 3}, db);
        m.getPixel(1, 2, pixel, db);
        harness.check(Arrays.equals(pixel, new int[]{1, 2, 3}));
        pixel = m.getPixel(1, 2, (int[])null, db);
        harness.check(Arrays.equals(pixel, new int[]{1, 2, 3}));
        boolean pass = false;
        try {
            m.getPixel(1, 2, pixel, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        m = new MultiPixelPackedSampleModel(0, 10, 20, 2);
        db = m.createDataBuffer();
        db.setElem(0, 27);
        harness.check(m.getPixel(0, 0, (int[])null, db)[0], 0);
        harness.check(m.getPixel(1, 0, (int[])null, db)[0], 1);
        harness.check(m.getPixel(2, 0, (int[])null, db)[0], 2);
        harness.check(m.getPixel(3, 0, (int[])null, db)[0], 3);
        db.setElem(3, 27);
        harness.check(m.getPixel(0, 1, (int[])null, db)[0], 0);
        harness.check(m.getPixel(1, 1, (int[])null, db)[0], 1);
        harness.check(m.getPixel(2, 1, (int[])null, db)[0], 2);
        harness.check(m.getPixel(3, 1, (int[])null, db)[0], 3);
        db.setElem(6, 24);
        db.setElem(9, 48);
        db.setElem(12, 28);
        harness.check(m.getPixel(1, 2, (int[])null, db)[0], 1);
        harness.check(m.getPixel(2, 2, (int[])null, db)[0], 2);
        harness.check(m.getPixel(1, 3, (int[])null, db)[0], 3);
        harness.check(m.getPixel(2, 3, (int[])null, db)[0], 0);
        harness.check(m.getPixel(1, 4, (int[])null, db)[0], 1);
        harness.check(m.getPixel(2, 4, (int[])null, db)[0], 3);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int, int, float[], DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        float[] pixel = new float[3];
        m.getPixel(1, 2, pixel, db);
        harness.check(Arrays.equals(pixel, new float[]{0.0f, 0.0f, 0.0f}));
        ((SampleModel)m).setPixel(1, 2, new int[]{1, 2, 3}, db);
        m.getPixel(1, 2, pixel, db);
        harness.check(Arrays.equals(pixel, new float[]{1.0f, 2.0f, 3.0f}));
        pixel = m.getPixel(1, 2, (float[])null, db);
        harness.check(Arrays.equals(pixel, new float[]{1.0f, 2.0f, 3.0f}));
        boolean pass = false;
        try {
            m.getPixel(1, 2, pixel, (DataBuffer)null);
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
        ((SampleModel)m).setPixel(1, 2, new int[]{1, 2, 3}, db);
        m.getPixel(1, 2, pixel, db);
        harness.check(Arrays.equals(pixel, new double[]{1.0, 2.0, 3.0}));
        pixel = m.getPixel(1, 2, (double[])null, db);
        harness.check(Arrays.equals(pixel, new double[]{1.0, 2.0, 3.0}));
        boolean pass = false;
        try {
            m.getPixel(1, 2, pixel, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

