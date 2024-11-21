/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;

public class getNumDataElements
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ComponentSampleModel m = new ComponentSampleModel(3, 3, 2, 2, 6, new int[]{0, 1});
        harness.check(m.getNumDataElements(), 2);
    }
}

