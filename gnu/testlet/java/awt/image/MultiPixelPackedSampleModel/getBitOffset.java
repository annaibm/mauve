/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.MultiPixelPackedSampleModel;

public class getBitOffset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        harness.check(m.getBitOffset(0), 0);
        harness.check(m.getBitOffset(1), 8);
        harness.check(m.getBitOffset(2), 16);
        harness.check(m.getBitOffset(3), 24);
        harness.check(m.getBitOffset(4), 0);
        harness.check(m.getBitOffset(5), 8);
        harness.check(m.getBitOffset(6), 16);
        harness.check(m.getBitOffset(7), 24);
        harness.check(m.getBitOffset(8), 0);
        harness.check(m.getBitOffset(9), 8);
        harness.check(m.getBitOffset(-1), -8);
        MultiPixelPackedSampleModel m2 = new MultiPixelPackedSampleModel(3, 10, 20, 8, 4, 16);
        harness.check(m2.getBitOffset(0), 16);
        harness.check(m2.getBitOffset(1), 24);
        harness.check(m2.getBitOffset(2), 0);
        harness.check(m2.getBitOffset(3), 8);
        harness.check(m2.getBitOffset(4), 16);
        harness.check(m2.getBitOffset(5), 24);
        harness.check(m2.getBitOffset(6), 0);
        harness.check(m2.getBitOffset(7), 8);
        harness.check(m2.getBitOffset(8), 16);
        harness.check(m2.getBitOffset(9), 24);
        harness.check(m2.getBitOffset(-1), 8);
        MultiPixelPackedSampleModel m3 = new MultiPixelPackedSampleModel(3, 10, 20, 16);
        harness.check(m3.getBitOffset(0), 0);
        harness.check(m3.getBitOffset(1), 16);
        harness.check(m3.getBitOffset(2), 0);
        harness.check(m3.getBitOffset(3), 16);
        harness.check(m3.getBitOffset(4), 0);
        harness.check(m3.getBitOffset(5), 16);
        harness.check(m3.getBitOffset(6), 0);
        harness.check(m3.getBitOffset(7), 16);
        harness.check(m3.getBitOffset(8), 0);
        harness.check(m3.getBitOffset(9), 16);
        harness.check(m3.getBitOffset(-1), -16);
    }
}

