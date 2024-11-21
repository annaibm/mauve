/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.RenderingHints;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RenderingHints h1 = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        RenderingHints h2 = (RenderingHints)h1.clone();
        harness.check(h2.containsKey(RenderingHints.KEY_TEXT_ANTIALIASING));
        harness.check(h2.get(RenderingHints.KEY_TEXT_ANTIALIASING).equals(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF));
        h1.clear();
        harness.check(h2.containsKey(RenderingHints.KEY_TEXT_ANTIALIASING));
        harness.check(h2.get(RenderingHints.KEY_TEXT_ANTIALIASING).equals(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF));
    }
}

