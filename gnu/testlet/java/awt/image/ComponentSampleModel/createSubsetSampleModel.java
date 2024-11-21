/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;
import java.awt.image.SampleModel;

public class createSubsetSampleModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ComponentSampleModel m1 = new ComponentSampleModel(3, 22, 11, 2, 44, new int[]{0, 1});
        SampleModel m2 = m1.createSubsetSampleModel(new int[]{1});
        harness.check(m2 instanceof ComponentSampleModel);
        harness.check(m2.getDataType(), 3);
        harness.check(m2.getWidth(), 22);
        harness.check(m2.getHeight(), 11);
        harness.check(m2.getNumBands(), 1);
    }
}

