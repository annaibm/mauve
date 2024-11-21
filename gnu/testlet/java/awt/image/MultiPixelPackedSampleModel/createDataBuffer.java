/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.MultiPixelPackedSampleModel;

public class createDataBuffer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        DataBuffer db = m.createDataBuffer();
        harness.check(db.getDataType(), 3);
        harness.check(db.getNumBanks(), 1);
        harness.check(db.getSize(), 60);
        MultiPixelPackedSampleModel m2 = new MultiPixelPackedSampleModel(3, 10, 20, 8, 4, 16);
        DataBuffer db2 = m2.createDataBuffer();
        harness.check(db2.getDataType(), 3);
        harness.check(db2.getNumBanks(), 1);
        harness.check(db2.getSize(), 81);
        MultiPixelPackedSampleModel m3 = new MultiPixelPackedSampleModel(0, 10, 20, 8);
        DataBuffer db3 = m3.createDataBuffer();
        harness.check(db3.getDataType(), 0);
        harness.check(db3.getNumBanks(), 1);
        harness.check(db3.getSize(), 200);
        MultiPixelPackedSampleModel m4 = new MultiPixelPackedSampleModel(0, 10, 20, 8, 11, 16);
        DataBuffer db4 = m4.createDataBuffer();
        harness.check(db4.getDataType(), 0);
        harness.check(db4.getNumBanks(), 1);
        harness.check(db4.getSize(), 222);
        MultiPixelPackedSampleModel m5 = new MultiPixelPackedSampleModel(1, 10, 20, 8);
        DataBuffer db5 = m5.createDataBuffer();
        harness.check(db5.getDataType(), 1);
        harness.check(db5.getNumBanks(), 1);
        harness.check(db5.getSize(), 100);
        MultiPixelPackedSampleModel m6 = new MultiPixelPackedSampleModel(1, 10, 20, 8, 6, 16);
        DataBuffer db6 = m6.createDataBuffer();
        harness.check(db6.getDataType(), 1);
        harness.check(db6.getNumBanks(), 1);
        harness.check(db6.getSize(), 121);
    }
}

