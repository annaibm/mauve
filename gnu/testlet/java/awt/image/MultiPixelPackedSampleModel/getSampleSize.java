/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.MultiPixelPackedSampleModel;

public class getSampleSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("()");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 1);
        harness.check(m.getSampleSize()[0], 1);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 2);
        harness.check(m.getSampleSize()[0], 2);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 4);
        harness.check(m.getSampleSize()[0], 4);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        harness.check(m.getSampleSize()[0], 8);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 16);
        harness.check(m.getSampleSize()[0], 16);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 32);
        harness.check(m.getSampleSize()[0], 32);
        int[] sizes = m.getSampleSize();
        harness.check(sizes[0], 32);
        sizes[0] = 99;
        int[] sizes2 = m.getSampleSize();
        harness.check(sizes != sizes2);
        harness.check(sizes2[0], 32);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int)");
        MultiPixelPackedSampleModel m = new MultiPixelPackedSampleModel(3, 10, 20, 1);
        harness.check(m.getSampleSize(0), 1);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 2);
        harness.check(m.getSampleSize(0), 2);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 4);
        harness.check(m.getSampleSize(0), 4);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 8);
        harness.check(m.getSampleSize(0), 8);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 16);
        harness.check(m.getSampleSize(0), 16);
        m = new MultiPixelPackedSampleModel(3, 10, 20, 32);
        harness.check(m.getSampleSize(0), 32);
        harness.check(m.getSampleSize(-1), 32);
        harness.check(m.getSampleSize(1), 32);
    }
}

