/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SinglePixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.SinglePixelPackedSampleModel;
import java.util.Arrays;

public class getBitOffsets
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(0, 1, 2, new int[]{224, 28, 3});
        harness.check(Arrays.equals(m1.getBitOffsets(), new int[]{5, 2, 0}));
    }
}

