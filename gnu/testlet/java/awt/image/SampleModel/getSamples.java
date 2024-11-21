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

public class getSamples
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
        this.testMethod3(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, int, int[], DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        int[] samples = new int[6];
        ((SampleModel)m).getSamples(1, 2, 2, 3, 1, samples, db);
        harness.check(Arrays.equals(samples, new int[]{0, 0, 0, 0, 0, 0}));
        ((SampleModel)m).setPixels(1, 2, 2, 3, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, db);
        ((SampleModel)m).getSamples(1, 2, 2, 3, 0, samples, db);
        harness.check(Arrays.equals(samples, new int[]{1, 4, 7, 2, 5, 0}));
        ((SampleModel)m).getSamples(1, 2, 2, 3, 1, samples, db);
        harness.check(Arrays.equals(samples, new int[]{2, 5, 0, 3, 6, 1}));
        ((SampleModel)m).getSamples(1, 2, 2, 3, 2, samples, db);
        harness.check(Arrays.equals(samples, new int[]{3, 2, 1, 0, 3, 2}));
        samples = ((SampleModel)m).getSamples(1, 2, 2, 3, 2, (int[])null, db);
        harness.check(Arrays.equals(samples, new int[]{3, 2, 1, 0, 3, 2}));
        boolean pass = false;
        try {
            ((SampleModel)m).getSamples(1, 2, 2, 3, 3, samples, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ((SampleModel)m).getSamples(1, 2, 2, 3, 0, samples, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, int, float[], DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        float[] samples = new float[6];
        m.getSamples(1, 2, 2, 3, 1, samples, db);
        harness.check(Arrays.equals(samples, new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}));
        ((SampleModel)m).setPixels(1, 2, 2, 3, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, db);
        m.getSamples(1, 2, 2, 3, 0, samples, db);
        harness.check(Arrays.equals(samples, new float[]{1.0f, 4.0f, 7.0f, 2.0f, 5.0f, 0.0f}));
        m.getSamples(1, 2, 2, 3, 1, samples, db);
        harness.check(Arrays.equals(samples, new float[]{2.0f, 5.0f, 0.0f, 3.0f, 6.0f, 1.0f}));
        m.getSamples(1, 2, 2, 3, 2, samples, db);
        harness.check(Arrays.equals(samples, new float[]{3.0f, 2.0f, 1.0f, 0.0f, 3.0f, 2.0f}));
        samples = m.getSamples(1, 2, 2, 3, 2, (float[])null, db);
        harness.check(Arrays.equals(samples, new float[]{3.0f, 2.0f, 1.0f, 0.0f, 3.0f, 2.0f}));
        boolean pass = false;
        try {
            m.getSamples(1, 2, 2, 3, 3, samples, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSamples(1, 2, 2, 3, 0, samples, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod3(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, int, double[], DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        double[] samples = new double[6];
        m.getSamples(1, 2, 2, 3, 1, samples, db);
        harness.check(Arrays.equals(samples, new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0}));
        ((SampleModel)m).setPixels(1, 2, 2, 3, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}, db);
        m.getSamples(1, 2, 2, 3, 0, samples, db);
        harness.check(Arrays.equals(samples, new double[]{1.0, 4.0, 7.0, 2.0, 5.0, 0.0}));
        m.getSamples(1, 2, 2, 3, 1, samples, db);
        harness.check(Arrays.equals(samples, new double[]{2.0, 5.0, 0.0, 3.0, 6.0, 1.0}));
        m.getSamples(1, 2, 2, 3, 2, samples, db);
        harness.check(Arrays.equals(samples, new double[]{3.0, 2.0, 1.0, 0.0, 3.0, 2.0}));
        samples = m.getSamples(1, 2, 2, 3, 2, (double[])null, db);
        harness.check(Arrays.equals(samples, new double[]{3.0, 2.0, 1.0, 0.0, 3.0, 2.0}));
        boolean pass = false;
        try {
            m.getSamples(1, 2, 2, 3, 3, samples, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getSamples(1, 2, 2, 3, 0, samples, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

