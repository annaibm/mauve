/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.MultiPixelPackedSampleModel;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MultiPixelPackedSampleModel m1 = new MultiPixelPackedSampleModel(3, 10, 20, 8, 5, 1);
        MultiPixelPackedSampleModel m2 = new MultiPixelPackedSampleModel(3, 10, 20, 8, 5, 1);
        harness.check(m1.equals(m2));
        harness.check(m2.equals(m1));
        m1 = new MultiPixelPackedSampleModel(0, 10, 20, 8, 5, 1);
        harness.check(!m1.equals(m2));
        m2 = new MultiPixelPackedSampleModel(0, 10, 20, 8, 5, 1);
        harness.check(m1.equals(m2));
        m1 = new MultiPixelPackedSampleModel(0, 11, 20, 8, 5, 1);
        harness.check(!m1.equals(m2));
        m2 = new MultiPixelPackedSampleModel(0, 11, 20, 8, 5, 1);
        harness.check(m1.equals(m2));
        m1 = new MultiPixelPackedSampleModel(0, 11, 21, 8, 5, 1);
        harness.check(!m1.equals(m2));
        m2 = new MultiPixelPackedSampleModel(0, 11, 21, 8, 5, 1);
        harness.check(m1.equals(m2));
        m1 = new MultiPixelPackedSampleModel(0, 11, 21, 4, 5, 1);
        harness.check(!m1.equals(m2));
        m2 = new MultiPixelPackedSampleModel(0, 11, 21, 4, 5, 1);
        harness.check(m1.equals(m2));
        m1 = new MultiPixelPackedSampleModel(0, 11, 21, 4, 6, 1);
        harness.check(!m1.equals(m2));
        m2 = new MultiPixelPackedSampleModel(0, 11, 21, 4, 6, 1);
        harness.check(m1.equals(m2));
        m1 = new MultiPixelPackedSampleModel(0, 11, 21, 4, 6, 2);
        harness.check(!m1.equals(m2));
        m2 = new MultiPixelPackedSampleModel(0, 11, 21, 4, 6, 2);
        harness.check(m1.equals(m2));
        harness.check(!m1.equals(null));
        harness.check(!m1.equals("Hello World!"));
    }
}

