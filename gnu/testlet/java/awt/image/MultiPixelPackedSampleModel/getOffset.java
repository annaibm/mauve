/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.MultiPixelPackedSampleModel;

public class getOffset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        harness.check(m.getOffset(0, 0), 0);
        harness.check(m.getOffset(1, 1), 3);
        harness.check(m.getOffset(2, 2), 6);
        harness.check(m.getOffset(3, 3), 9);
        harness.check(m.getOffset(4, 4), 13);
        harness.check(m.getOffset(5, 15), 46);
        harness.check(m.getOffset(6, 16), 49);
        harness.check(m.getOffset(7, 17), 52);
        harness.check(m.getOffset(8, 18), 56);
        harness.check(m.getOffset(9, 19), 59);
        MultiPixelPackedSampleModel m2 = new MultiPixelPackedSampleModel(3, 10, 20, 8, 4, 16);
        harness.check(m2.getDataBitOffset(), 16);
        harness.check(m2.getOffset(0, 0), 0);
        harness.check(m2.getOffset(1, 1), 4);
        harness.check(m2.getOffset(2, 2), 9);
        harness.check(m2.getOffset(3, 3), 13);
        harness.check(m2.getOffset(4, 4), 17);
        harness.check(m2.getOffset(5, 15), 61);
        harness.check(m2.getOffset(6, 16), 66);
        harness.check(m2.getOffset(7, 17), 70);
        harness.check(m2.getOffset(8, 18), 74);
        harness.check(m2.getOffset(9, 19), 78);
    }
}

