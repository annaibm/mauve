/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.RescaleOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;
import java.awt.image.RescaleOp;

public class getRenderingHints
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RenderingHints r = new RenderingHints(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        RescaleOp op = new RescaleOp(1.0f, 1.0f, r);
        harness.check(op.getRenderingHints() == r);
        op = new RescaleOp(1.0f, 1.0f, null);
        harness.check(op.getRenderingHints() == null);
    }
}

