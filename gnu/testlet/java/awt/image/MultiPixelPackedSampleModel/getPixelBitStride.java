/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.MultiPixelPackedSampleModel;

public class getPixelBitStride
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        harness.check(m.getPixelBitStride(), 8);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 1);
        harness.check(m.getPixelBitStride(), 1);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 2);
        harness.check(m.getPixelBitStride(), 2);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 4);
        harness.check(m.getPixelBitStride(), 4);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 16);
        harness.check(m.getPixelBitStride(), 16);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 32);
        harness.check(m.getPixelBitStride(), 32);
    }
}

