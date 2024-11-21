/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.RenderingHints;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;

public class containsValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RenderingHints h1 = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        harness.check(h1.containsValue(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF));
        harness.check(!h1.containsValue(RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        harness.check(!h1.containsValue(null));
    }
}

