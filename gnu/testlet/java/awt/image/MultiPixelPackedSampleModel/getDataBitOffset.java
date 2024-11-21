/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import java.awt.image.MultiPixelPackedSampleModel;

public class getDataBitOffset {
    public void test(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        harness.check(m.getDataBitOffset(), 0);
        MultiPixelPackedSampleModel m2 = new MultiPixelPackedSampleModel(3, 10, 20, 8, 4, 16);
        harness.check(m2.getDataBitOffset(), 16);
    }
}

