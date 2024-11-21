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

public class setSamples
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
        ((SampleModel)m).setSamples(1, 2, 2, 3, 0, new int[]{1, 2, 3, 4, 5, 6}, db);
        ((SampleModel)m).getSamples(1, 2, 2, 3, 0, samples, db);
        harness.check(Arrays.equals(samples, new int[]{1, 2, 3, 4, 5, 6}));
        ((SampleModel)m).setSamples(1, 2, 2, 3, 1, new int[]{7, 8, 9, 10, 11, 12}, db);
        ((SampleModel)m).getSamples(1, 2, 2, 3, 1, samples, db);
        harness.check(Arrays.equals(samples, new int[]{7, 0, 1, 2, 3, 4}));
        ((SampleModel)m).setSamples(1, 2, 2, 3, 2, new int[]{13, 14, 15, 16, 17, 18}, db);
        ((SampleModel)m).getSamples(1, 2, 2, 3, 2, samples, db);
        harness.check(Arrays.equals(samples, new int[]{1, 2, 3, 0, 1, 2}));
        boolean pass = false;
        try {
            ((SampleModel)m).setSamples(1, 2, 2, 3, 3, samples, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ((SampleModel)m).setSamples(1, 2, 2, 3, 0, (int[])null, db);
        }
        catch (NullPointerException e) {
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
        m.setSamples(1, 2, 2, 3, 0, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f}, db);
        m.getSamples(1, 2, 2, 3, 0, samples, db);
        harness.check(Arrays.equals(samples, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f}));
        m.setSamples(1, 2, 2, 3, 1, new float[]{7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f}, db);
        m.getSamples(1, 2, 2, 3, 1, samples, db);
        harness.check(Arrays.equals(samples, new float[]{7.0f, 0.0f, 1.0f, 2.0f, 3.0f, 4.0f}));
        m.setSamples(1, 2, 2, 3, 2, new float[]{13.0f, 14.0f, 15.0f, 16.0f, 17.0f, 18.0f}, db);
        m.getSamples(1, 2, 2, 3, 2, samples, db);
        harness.check(Arrays.equals(samples, new float[]{1.0f, 2.0f, 3.0f, 0.0f, 1.0f, 2.0f}));
        boolean pass = false;
        try {
            m.setSamples(1, 2, 2, 3, 3, samples, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSamples(1, 2, 2, 3, 0, (float[])null, db);
        }
        catch (NullPointerException e) {
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
        m.setSamples(1, 2, 2, 3, 0, new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0}, db);
        m.getSamples(1, 2, 2, 3, 0, samples, db);
        harness.check(Arrays.equals(samples, new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0}));
        m.setSamples(1, 2, 2, 3, 1, new double[]{7.0, 8.0, 9.0, 10.0, 11.0, 12.0}, db);
        m.getSamples(1, 2, 2, 3, 1, samples, db);
        harness.check(Arrays.equals(samples, new double[]{7.0, 0.0, 1.0, 2.0, 3.0, 4.0}));
        m.setSamples(1, 2, 2, 3, 2, new double[]{13.0, 14.0, 15.0, 16.0, 17.0, 18.0}, db);
        m.getSamples(1, 2, 2, 3, 2, samples, db);
        harness.check(Arrays.equals(samples, new double[]{1.0, 2.0, 3.0, 0.0, 1.0, 2.0}));
        boolean pass = false;
        try {
            m.setSamples(1, 2, 2, 3, 3, samples, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSamples(1, 2, 2, 3, 0, (double[])null, db);
        }
        catch (NullPointerException e) {
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

