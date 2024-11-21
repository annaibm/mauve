/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.MultiPixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.MultiPixelPackedSampleModel;

public class hashCode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MultiPixelPackedSampleModel m1 = new MultiPixelPackedSampleModel(3, 10, 20, 8, 5, 1);
        MultiPixelPackedSampleModel m2 = new MultiPixelPackedSampleModel(3, 10, 20, 8, 5, 1);
        harness.check(m1.equals(m2));
        harness.check(m1.hashCode(), m2.hashCode());
    }
}

