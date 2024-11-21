/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.Kernel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.Kernel;

public class getHeight
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Kernel k1 = new Kernel(1, 2, new float[]{1.0f, 2.0f});
        harness.check(k1.getHeight(), 2);
    }
}

