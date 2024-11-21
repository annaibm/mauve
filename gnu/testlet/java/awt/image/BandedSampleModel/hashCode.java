/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BandedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BandedSampleModel;

public class hashCode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BandedSampleModel m1 = new BandedSampleModel(3, 2, 3, 2);
        BandedSampleModel m2 = new BandedSampleModel(3, 2, 3, 2);
        harness.check(m1.hashCode(), m2.hashCode());
    }
}

