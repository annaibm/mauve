/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;

public class getSampleFloat
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(int, int, int, DataBuffer)");
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        harness.check(m.getSampleFloat(1, 2, 0, db), 0.0);
        harness.check(m.getSampleFloat(1, 2, 1, db), 0.0);
        harness.check(m.getSampleFloat(1, 2, 2, db), 0.0);
        ((SampleModel)m).setPixel(1, 2, new int[]{1, 2, 3}, db);
        harness.check(m.getSampleFloat(1, 2, 0, db), 1.0);
        harness.check(m.getSampleFloat(1, 2, 1, db), 2.0);
        harness.check(m.getSampleFloat(1, 2, 2, db), 3.0);
        boolean pass = false;
        try {
            m.getSampleFloat(1, 2, -1, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(true);
        pass = false;
        try {
            m.getSampleFloat(1, 2, 3, db);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(true);
        pass = false;
        try {
            m.getSampleFloat(1, 2, 0, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

