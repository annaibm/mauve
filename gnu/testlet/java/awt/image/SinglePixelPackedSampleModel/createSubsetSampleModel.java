/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SinglePixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.RasterFormatException;
import java.awt.image.SinglePixelPackedSampleModel;
import java.util.Arrays;

public class createSubsetSampleModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(0, 1, 2, new int[]{224, 28, 3});
        SinglePixelPackedSampleModel m2 = (SinglePixelPackedSampleModel)m1.createSubsetSampleModel(new int[]{0, 2});
        harness.check(m2.getDataType(), 0);
        harness.check(m2.getWidth(), 1);
        harness.check(m2.getHeight(), 2);
        harness.check(m2.getNumBands(), 2);
        harness.check(Arrays.equals(new int[]{224, 3}, m2.getBitMasks()));
        try {
            m1.createSubsetSampleModel(new int[]{0, 5});
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.createSubsetSampleModel(new int[]{0, 1, 2, 0});
            harness.check(false);
        }
        catch (RasterFormatException e) {
            harness.check(true);
        }
    }
}

