/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;
import java.util.Arrays;

public class getBandOffsets
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int[] bo = new int[]{1, 2};
        ComponentSampleModel m1 = new ComponentSampleModel(3, 22, 33, 1, 23, bo);
        int[] bo1 = m1.getBandOffsets();
        harness.check(Arrays.equals(bo1, new int[]{1, 2}));
        int[] bo2 = m1.getBandOffsets();
        harness.check(bo1 != bo2);
        bo[1] = 3;
        harness.check(m1.getBandOffsets()[1], 2);
    }
}

