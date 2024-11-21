/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ConvolveOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.Arrays;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("(Kernel)");
        Kernel k1 = new Kernel(3, 3, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f});
        ConvolveOp op1 = new ConvolveOp(k1);
        harness.check(op1.getKernel() != k1);
        harness.check(Arrays.equals(op1.getKernel().getKernelData(null), k1.getKernelData(null)));
        harness.check(op1.getEdgeCondition(), 0);
        harness.check(op1.getRenderingHints(), null);
        boolean pass = true;
        try {
            new ConvolveOp(null);
        }
        catch (NullPointerException e) {
            pass = false;
        }
        harness.check(pass);
        pass = false;
        try {
            ConvolveOp op2 = new ConvolveOp(null);
            op2.getKernel();
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(Kernel, int, RenderingHints)");
        Kernel k1 = new Kernel(3, 3, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f});
        ConvolveOp op1 = new ConvolveOp(k1, 1, null);
        harness.check(op1.getKernel() != k1);
        harness.check(Arrays.equals(op1.getKernel().getKernelData(null), k1.getKernelData(null)));
        harness.check(op1.getEdgeCondition(), 1);
        harness.check(op1.getRenderingHints(), null);
        boolean pass = false;
        ConvolveOp op2 = new ConvolveOp(null, 1, null);
        try {
            op2.getKernel();
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        op1 = new ConvolveOp(k1, -1, null);
        harness.check(op1.getEdgeCondition(), -1);
    }
}

