/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;

public class hashCode
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ComponentSampleModel m1 = new ComponentSampleModel(3, 10, 20, 3, 3, new int[]{0, 1, 2});
        ComponentSampleModel m2 = new ComponentSampleModel(3, 10, 20, 3, 3, new int[]{0, 1, 2});
        harness.check(m1.equals(m2));
        harness.check(m1.hashCode(), m2.hashCode());
    }
}

