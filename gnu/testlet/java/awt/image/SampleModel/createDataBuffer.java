/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;

public class createDataBuffer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(0, 10, 20, new int[]{224, 28, 3});
        DataBuffer db = ((SampleModel)m).createDataBuffer();
        harness.check(db.getDataType(), 0);
        harness.check(db.getNumBanks(), 1);
        harness.check(db.getSize(), 200);
        harness.check(db.getOffsets()[0], 0);
    }
}

