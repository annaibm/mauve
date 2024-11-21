/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.MultiPixelPackedSampleModel;

public class getScanlineStride
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        harness.check(m.getScanlineStride(), 3);
        MultiPixelPackedSampleModel m2 = new MultiPixelPackedSampleModel(3, 10, 20, 8, 4, 16);
        harness.check(m2.getScanlineStride(), 4);
    }
}

