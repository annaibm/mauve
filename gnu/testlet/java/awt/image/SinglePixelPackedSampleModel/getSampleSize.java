/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SinglePixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.SinglePixelPackedSampleModel;

public class getSampleSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        int[] bitMasks = new int[]{240, 8, 6, 1};
        SinglePixelPackedSampleModel sm = new SinglePixelPackedSampleModel(0, 5, 3, bitMasks);
        harness.check(sm.getSampleSize(0), 4);
        harness.check(sm.getSampleSize(1), 1);
        harness.check(sm.getSampleSize(2), 2);
        harness.check(sm.getSampleSize(3), 1);
        try {
            sm.getSampleSize(4);
            harness.check(false);
        }
        catch (RuntimeException ex) {
            harness.check(true);
        }
        try {
            sm.getSampleSize(-1);
            harness.check(false);
        }
        catch (RuntimeException ex) {
            harness.check(true);
        }
        int[] sizes = sm.getSampleSize();
        harness.check(sizes.length, 4);
        harness.check(sizes[0], 4);
        harness.check(sizes[1], 1);
        harness.check(sizes[2], 2);
        harness.check(sizes[3], 1);
    }

    public void test2(TestHarness harness) {
        SinglePixelPackedSampleModel m = new SinglePixelPackedSampleModel(3, 10, 20, new int[]{255, 65280, 0xFF0000, -16777216});
        int[] sizes = m.getSampleSize();
        harness.check(sizes.length, 4);
        harness.check(sizes[0], 8);
        harness.check(sizes[1], 8);
        harness.check(sizes[2], 8);
        harness.check(sizes[3], 8);
        sizes[0] = 99;
        int[] sizes2 = m.getSampleSize();
        harness.check(sizes2 != sizes);
        harness.check(sizes2[0], 8);
    }
}

