/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;

public class getSampleSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("()");
        ComponentSampleModel m1 = new ComponentSampleModel(3, 22, 11, 2, 44, new int[]{0, 0});
        int[] sizes = m1.getSampleSize();
        harness.check(sizes.length, 2);
        harness.check(sizes[0], 32);
        harness.check(sizes[1], 32);
        ComponentSampleModel m2 = new ComponentSampleModel(0, 22, 11, 2, 44, new int[]{0, 0, 0});
        int[] sizes2 = m2.getSampleSize();
        harness.check(sizes2.length, 3);
        harness.check(sizes2[0], 8);
        harness.check(sizes2[1], 8);
        harness.check(sizes2[2], 8);
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("(int)");
        ComponentSampleModel m1 = new ComponentSampleModel(3, 22, 11, 2, 44, new int[]{0, 0});
        harness.check(m1.getSampleSize(0), 32);
        harness.check(m1.getSampleSize(1), 32);
        harness.check(m1.getSampleSize(2), 32);
        harness.check(m1.getSampleSize(3), 32);
        harness.check(m1.getSampleSize(-1), 32);
    }
}

