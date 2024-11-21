/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.MultiPixelPackedSampleModel;

public class createCompatibleSampleModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MultiPixelPackedSampleModel m1 = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        MultiPixelPackedSampleModel m2 = (MultiPixelPackedSampleModel)m1.createCompatibleSampleModel(5, 10);
        harness.check(m2.getDataType(), 3);
        harness.check(m2.getWidth(), 5);
        harness.check(m2.getHeight(), 10);
        harness.check(m2.getNumBands(), 1);
        harness.check(m2.getScanlineStride(), 2);
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

