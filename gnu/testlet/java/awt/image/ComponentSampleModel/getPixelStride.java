/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ComponentSampleModel;

public class getPixelStride
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ComponentSampleModel m1 = new ComponentSampleModel(3, 22, 11, 2, 44, new int[]{0, 0});
        harness.check(m1.getPixelStride(), 2);
    }
}

