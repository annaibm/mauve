/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.RenderingHints;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;
import java.util.Set;

public class keySet
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RenderingHints h1 = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        Set<Object> k = h1.keySet();
        harness.check(k.size() == 1);
        h1.clear();
        harness.check(k.isEmpty());
    }
}

