/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ConvolveOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.Arrays;

public class getKernel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Kernel k1 = new Kernel(1, 1, new float[]{1.0f});
        ConvolveOp op1 = new ConvolveOp(k1);
        Kernel k2 = op1.getKernel();
        harness.check(Arrays.equals(k1.getKernelData(null), k2.getKernelData(null)));
        harness.check(k1 != k2);
        Kernel k3 = op1.getKernel();
        harness.check(k2 != k3);
    }
}

