/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.RenderingHints;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;
import java.util.Collection;

public class values
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RenderingHints h1 = new RenderingHints(null);
        Collection<Object> v1 = h1.values();
        harness.check(v1.isEmpty());
        h1.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);
        harness.check(v1.size() == 1);
        harness.check(v1.contains(RenderingHints.VALUE_DITHER_DISABLE));
    }
}

