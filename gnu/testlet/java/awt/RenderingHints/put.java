/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.RenderingHints;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;

public class put
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RenderingHints h1 = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        h1.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        harness.check(h1.size() == 2);
        harness.check(h1.containsKey(RenderingHints.KEY_ANTIALIASING));
        harness.check(h1.get(RenderingHints.KEY_ANTIALIASING).equals(RenderingHints.VALUE_ANTIALIAS_ON));
        boolean pass = false;
        try {
            h1.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            h1.put(RenderingHints.KEY_ANTIALIASING, (Object)null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            h1.put(new Integer(1), (Object)null);
        }
        catch (ClassCastException e) {
            pass = true;
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            h1.put((Object)null, (Object)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

