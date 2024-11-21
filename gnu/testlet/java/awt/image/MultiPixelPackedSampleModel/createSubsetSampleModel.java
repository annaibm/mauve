/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.MultiPixelPackedSampleModel;
import java.awt.image.RasterFormatException;

public class createSubsetSampleModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MultiPixelPackedSampleModel m1 = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        MultiPixelPackedSampleModel m2 = (MultiPixelPackedSampleModel)m1.createSubsetSampleModel(new int[]{2});
        harness.check(m2.getDataType(), 3);
        harness.check(m2.getWidth(), 10);
        harness.check(m2.getHeight(), 20);
        harness.check(m2.getNumBands(), 1);
        boolean pass = false;
        try {
            m1.createSubsetSampleModel(new int[]{2, 3});
        }
        catch (RasterFormatException e) {
            pass = true;
        }
        harness.check(pass);
        MultiPixelPackedSampleModel m3 = (MultiPixelPackedSampleModel)m1.createSubsetSampleModel(null);
        harness.check(m3.getDataType(), 3);
        harness.check(m3.getWidth(), 10);
        harness.check(m3.getHeight(), 20);
        harness.check(m3.getNumBands(), 1);
    }
}

