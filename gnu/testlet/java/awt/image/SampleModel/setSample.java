/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;

public class setSample
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
        this.testMethod3(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        harness.check(((SampleModel)m).getSample(1, 2, 0, db), 0);
        ((SampleModel)m).setSample(1, 2, 0, 3, db);
        harness.check(((SampleModel)m).getSample(1, 2, 0, db), 3);
        boolean pass = true;
        try {
            ((SampleModel)m).setSample(1, 2, -1, 3, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            ((SampleModel)m).setSample(1, 2, 3, 3, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            ((SampleModel)m).setSample(1, 2, 2, 3, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int, int, int, float, DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        harness.check(((SampleModel)m).getSample(1, 2, 0, db), 0);
        m.setSample(1, 2, 0, 3.0f, db);
        harness.check(((SampleModel)m).getSample(1, 2, 0, db), 3);
        boolean pass = true;
        try {
            m.setSample(1, 2, -1, 3.0f, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            m.setSample(1, 2, 3, 3.0f, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSample(1, 2, 2, 3.0f, (DataBuffer)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testMethod3(TestHarness harness) {
        harness.checkPoint("(int, int, int, double, DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        harness.check(((SampleModel)m).getSample(1, 2, 0, db), 0);
        m.setSample(1, 2, 0, 3.0, db);
        harness.check(((SampleModel)m).getSample(1, 2, 0, db), 3);
        boolean pass = true;
        try {
            m.setSample(1, 2, -1, 3.0, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            m.setSample(1, 2, 3, 3.0, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setSample(1, 2, 2, 3.0, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

