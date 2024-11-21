/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.LookupOp;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;
import java.awt.image.ByteLookupTable;
import java.awt.image.LookupOp;

public class getRenderingHints
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        byte[] bytes = new byte[]{-86, -69};
        ByteLookupTable t = new ByteLookupTable(0, bytes);
        RenderingHints r = new RenderingHints(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        LookupOp op = new LookupOp(t, r);
        harness.check(op.getRenderingHints() == r);
        op = new LookupOp(t, null);
        harness.check(op.getRenderingHints() == null);
    }
}

