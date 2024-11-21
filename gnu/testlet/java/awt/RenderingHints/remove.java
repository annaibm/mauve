/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.RenderingHints;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;

public class remove
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RenderingHints h1 = new RenderingHints(null);
        Object result = h1.remove(RenderingHints.KEY_ALPHA_INTERPOLATION);
        harness.check(result == null);
        h1.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        result = h1.remove(RenderingHints.KEY_RENDERING);
        harness.check(result == RenderingHints.VALUE_RENDER_QUALITY);
        harness.check(h1.isEmpty());
        result = h1.remove(null);
        harness.check(result == null);
        boolean pass = false;
        try {
            h1.remove(new Integer(1));
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

