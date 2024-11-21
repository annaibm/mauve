/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.SampleModel;
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
        ComponentSampleModel m = new ComponentSampleModel(0, 5, 10, 3, 16, new int[]{0, 2, 1});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        int[] pixel = new int[3];
        ((SampleModel)m).getPixel(1, 2, pixel, db);
        harness.check(Arrays.equals(pixel, new int[]{0, 0, 0}));
        ((SampleModel)m).setPixel(1, 2, new int[]{1, 2, 3}, db);
        ((SampleModel)m).getPixel(1, 2, pixel, db);
        harness.check(Arrays.equals(pixel, new int[]{1, 2, 3}));
        pixel = ((SampleModel)m).getPixel(1, 2, (int[])null, db);
        harness.check(Arrays.equals(pixel, new int[]{1, 2, 3}));
        boolean pass = false;
        try {
            ((SampleModel)m).getPixel(-1, 1, (int[])null, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ((SampleModel)m).getPixel(5, 1, (int[])null, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ((SampleModel)m).getPixel(1, -1, (int[])null, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ((SampleModel)m).getPixel(1, 10, (int[])null, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ((SampleModel)m).getPixel(1, 2, pixel, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int, int, float[], DataBuffer)");
        ComponentSampleModel m = new ComponentSampleModel(0, 5, 10, 3, 16, new int[]{0, 2, 1});
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
            m.getPixel(-1, 1, (float[])null, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getPixel(5, 1, (float[])null, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getPixel(1, -1, (float[])null, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getPixel(1, 10, (float[])null, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getPixel(1, 2, pixel, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod3(TestHarness harness) {
        harness.checkPoint("(int, int, float[], DataBuffer)");
        ComponentSampleModel m = new ComponentSampleModel(0, 5, 10, 3, 16, new int[]{0, 2, 1});
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
            m.getPixel(-1, 1, (float[])null, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getPixel(5, 1, (float[])null, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getPixel(1, -1, (float[])null, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getPixel(1, 10, (float[])null, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.getPixel(1, 2, pixel, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

