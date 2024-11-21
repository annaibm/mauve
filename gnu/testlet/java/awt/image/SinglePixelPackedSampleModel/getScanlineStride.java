/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SinglePixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.SinglePixelPackedSampleModel;

public class getScanlineStride
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(0, 2, 2, new int[]{224, 28, 3});
        harness.check(m1.getScanlineStride(), 2);
        SinglePixelPackedSampleModel m2 = new SinglePixelPackedSampleModel(3, 20, 30, 22, new int[]{240, 15});
        harness.check(m2.getScanlineStride(), 22);
    }
}

