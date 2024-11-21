/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.RenderingHints;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;

public class containsKey
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RenderingHints h = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        harness.check(h.containsKey(RenderingHints.KEY_TEXT_ANTIALIASING));
        harness.check(!h.containsKey(RenderingHints.KEY_ANTIALIASING));
        boolean pass = false;
        try {
            h.containsKey(new Integer(1));
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            h.containsKey(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

