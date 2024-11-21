/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.RenderingHints;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;

public class get
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RenderingHints h1 = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        harness.check(h1.get(RenderingHints.KEY_TEXT_ANTIALIASING).equals(RenderingHints.VALUE_TEXT_ANTIALIAS_OFF));
        harness.check(h1.get(RenderingHints.KEY_ALPHA_INTERPOLATION), null);
        harness.check(h1.get(null) == null);
        boolean pass = false;
        try {
            h1.get(new Integer(1));
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

