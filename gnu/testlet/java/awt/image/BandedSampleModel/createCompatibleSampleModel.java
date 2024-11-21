/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandedSampleModel;

public class createCompatibleSampleModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BandedSampleModel m1 = new BandedSampleModel(2, 10, 20, 10, new int[]{3, 2, 1}, new int[]{4, 5, 6});
        BandedSampleModel m2 = (BandedSampleModel)m1.createCompatibleSampleModel(100, 200);
        harness.check(m2.getDataType(), 2);
        harness.check(m2.getWidth(), 100);
        harness.check(m2.getHeight(), 200);
        harness.check(m2.getScanlineStride(), 100);
        harness.check(m2.getNumBands(), 3);
        harness.check(m2.getBankIndices()[0], 3);
        harness.check(m2.getBankIndices()[1], 2);
        harness.check(m2.getBankIndices()[2], 1);
        harness.check(m2.getBandOffsets()[0], 0);
        harness.check(m2.getBandOffsets()[1], 0);
        harness.check(m2.getBandOffsets()[2], 0);
        boolean pass = false;
        try {
            m2 = (BandedSampleModel)m1.createCompatibleSampleModel(0, 200);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m2 = (BandedSampleModel)m1.createCompatibleSampleModel(100, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

