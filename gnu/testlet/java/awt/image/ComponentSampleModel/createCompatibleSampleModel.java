/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;
import java.awt.image.SampleModel;
import java.util.Arrays;

public class createCompatibleSampleModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ComponentSampleModel m1 = new ComponentSampleModel(3, 22, 11, 1, 25, new int[]{1, 2}, new int[]{3, 4});
        SampleModel m2 = m1.createCompatibleSampleModel(33, 44);
        harness.check(m2 instanceof ComponentSampleModel);
        harness.check(m2.getDataType(), 3);
        harness.check(m2.getWidth(), 33);
        harness.check(m2.getHeight(), 44);
        harness.check(m2.getNumBands(), 2);
        harness.check(Arrays.equals(m1.getBandOffsets(), new int[]{3, 4}));
        harness.check(Arrays.equals(m1.getBankIndices(), new int[]{1, 2}));
    }
}

