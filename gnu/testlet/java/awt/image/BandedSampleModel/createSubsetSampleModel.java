/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandedSampleModel;
import java.awt.image.RasterFormatException;

public class createSubsetSampleModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BandedSampleModel m1 = new BandedSampleModel(2, 10, 20, 10, new int[]{2, 1, 0}, new int[]{4, 5, 6});
        BandedSampleModel m2 = (BandedSampleModel)m1.createSubsetSampleModel(new int[]{0, 1});
        harness.check(m2.getDataType(), 2);
        harness.check(m2.getWidth(), 10);
        harness.check(m2.getHeight(), 20);
        harness.check(m2.getNumBands(), 2);
        harness.check(m2.getBandOffsets()[0], 4);
        harness.check(m2.getBandOffsets()[1], 5);
        boolean pass = false;
        try {
            m2 = (BandedSampleModel)m1.createSubsetSampleModel(new int[]{0, 1, 2, 3});
        }
        catch (RasterFormatException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

