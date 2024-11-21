/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.RenderingHints;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;
import java.util.HashMap;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RenderingHints h1 = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        RenderingHints h2 = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        harness.check(h1.equals(h2));
        harness.check(!h1.equals(null));
        HashMap<RenderingHints.Key, Object> m = new HashMap<RenderingHints.Key, Object>();
        m.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        harness.check(h1.equals(m));
        harness.check(m.equals(h1));
    }
}

