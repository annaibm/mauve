/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandedSampleModel;
import java.awt.image.DataBuffer;

public class createDataBuffer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BandedSampleModel m = new BandedSampleModel(2, 10, 20, 10, new int[]{2, 1, 0}, new int[]{0, 0, 0});
        DataBuffer b = m.createDataBuffer();
        harness.check(b.getDataType(), 2);
        harness.check(b.getNumBanks(), 3);
        harness.check(b.getSize(), 200);
        m = new BandedSampleModel(3, 4, 6, 10, new int[]{0, 1}, new int[]{0, 0});
        b = m.createDataBuffer();
        harness.check(b.getDataType(), 3);
        harness.check(b.getNumBanks(), 2);
        harness.check(b.getSize(), 60);
    }
}

