/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.Kernel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.Kernel;

public class getXOrigin
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Kernel k1 = new Kernel(3, 4, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f});
        harness.check(k1.getXOrigin(), 1);
        Kernel k2 = new Kernel(4, 3, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f});
        harness.check(k2.getXOrigin(), 1);
        Kernel k3 = new Kernel(5, 2, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f});
        harness.check(k3.getXOrigin(), 2);
    }
}

