/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ConvolveOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class getRenderingHints
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Kernel k1 = new Kernel(3, 3, new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f});
        RenderingHints r = new RenderingHints(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);
        ConvolveOp op = new ConvolveOp(k1, 1, r);
        harness.check(op.getRenderingHints(), r);
        harness.check(op.getRenderingHints().size(), 1);
        op = new ConvolveOp(k1, 1, null);
        harness.check(op.getRenderingHints(), null);
    }
}

