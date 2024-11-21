/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SinglePixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.SinglePixelPackedSampleModel;
import java.util.Arrays;

public class createCompatibleSampleModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(0, 1, 2, new int[]{224, 28, 3});
        SinglePixelPackedSampleModel m2 = (SinglePixelPackedSampleModel)m1.createCompatibleSampleModel(5, 10);
        harness.check(m2.getDataType(), 0);
        harness.check(m2.getWidth(), 5);
        harness.check(m2.getHeight(), 10);
        harness.check(m2.getNumBands(), 3);
        harness.check(Arrays.equals(m1.getBitMasks(), m2.getBitMasks()));
        try {
            m1.createCompatibleSampleModel(0, 10);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        try {
            m1.createCompatibleSampleModel(5, 0);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
    }
}

