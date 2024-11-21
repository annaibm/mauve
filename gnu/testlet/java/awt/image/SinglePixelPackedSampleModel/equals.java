/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SinglePixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.SinglePixelPackedSampleModel;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(0, 1, 2, new int[]{224, 28, 3});
        SinglePixelPackedSampleModel m2 = new SinglePixelPackedSampleModel(0, 1, 2, new int[]{224, 28, 3});
        harness.check(m1.equals(m2));
        harness.check(m2.equals(m1));
        harness.check(!m1.equals(null));
        m1 = new SinglePixelPackedSampleModel(3, 1, 2, new int[]{224, 28, 3});
        harness.check(!m1.equals(m2));
        m2 = new SinglePixelPackedSampleModel(3, 1, 2, new int[]{224, 28, 3});
        harness.check(m1.equals(m2));
        m1 = new SinglePixelPackedSampleModel(3, 5, 2, new int[]{224, 28, 3});
        harness.check(!m1.equals(m2));
        m2 = new SinglePixelPackedSampleModel(3, 5, 2, new int[]{224, 28, 3});
        harness.check(m1.equals(m2));
        m1 = new SinglePixelPackedSampleModel(3, 5, 10, new int[]{224, 28, 3});
        harness.check(!m1.equals(m2));
        m2 = new SinglePixelPackedSampleModel(3, 5, 10, new int[]{224, 28, 3});
        harness.check(m1.equals(m2));
        m1 = new SinglePixelPackedSampleModel(3, 5, 10, new int[]{224, 24, 7});
        harness.check(!m1.equals(m2));
        m2 = new SinglePixelPackedSampleModel(3, 5, 10, new int[]{224, 24, 7});
        harness.check(m1.equals(m2));
        m1 = new SinglePixelPackedSampleModel(3, 5, 10, 99, new int[]{224, 24, 7});
        harness.check(!m1.equals(m2));
        m2 = new SinglePixelPackedSampleModel(3, 5, 10, 99, new int[]{224, 24, 7});
        harness.check(m1.equals(m2));
    }
}

