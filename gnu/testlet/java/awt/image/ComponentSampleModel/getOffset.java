/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;

public class getOffset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMethod1(harness);
        this.testMethod2(harness);
    }

    public void testMethod1(TestHarness harness) {
        harness.checkPoint("(int, int)");
        ComponentSampleModel m = new ComponentSampleModel(0, 5, 10, 3, 15, new int[]{0, 1, 2});
        harness.check(m.getOffset(0, 0), 0);
        harness.check(m.getOffset(1, 0), 3);
        harness.check(m.getOffset(2, 0), 6);
        harness.check(m.getOffset(3, 0), 9);
        harness.check(m.getOffset(4, 0), 12);
        harness.check(m.getOffset(5, 0), 15);
        harness.check(m.getOffset(0, 1), 15);
        harness.check(m.getOffset(1, 1), 18);
        harness.check(m.getOffset(2, 1), 21);
        harness.check(m.getOffset(3, 1), 24);
        harness.check(m.getOffset(4, 1), 27);
        harness.check(m.getOffset(5, 1), 30);
    }

    public void testMethod2(TestHarness harness) {
        harness.checkPoint("(int, int, int)");
        ComponentSampleModel m = new ComponentSampleModel(0, 5, 10, 3, 15, new int[]{0, 1, 2});
        harness.check(m.getOffset(0, 0, 1), 1);
        harness.check(m.getOffset(1, 0, 1), 4);
        harness.check(m.getOffset(2, 0, 1), 7);
        harness.check(m.getOffset(3, 0, 1), 10);
        harness.check(m.getOffset(4, 0, 1), 13);
        harness.check(m.getOffset(5, 0, 1), 16);
        harness.check(m.getOffset(0, 1, 1), 16);
        harness.check(m.getOffset(1, 1, 1), 19);
        harness.check(m.getOffset(2, 1, 1), 22);
        harness.check(m.getOffset(3, 1, 1), 25);
        harness.check(m.getOffset(4, 1, 1), 28);
        harness.check(m.getOffset(5, 1, 1), 31);
    }
}

