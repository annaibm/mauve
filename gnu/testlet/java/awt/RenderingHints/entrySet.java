/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.RenderingHints;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;
import java.util.Map;
import java.util.Set;

public class entrySet
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RenderingHints h1 = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        Set<Map.Entry<Object, Object>> s = h1.entrySet();
        harness.check(s.size() == 1);
        h1.clear();
        s = h1.entrySet();
        harness.check(s.isEmpty());
    }
}

