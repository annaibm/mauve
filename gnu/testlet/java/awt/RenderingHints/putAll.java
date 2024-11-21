/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.RenderingHints;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;
import java.util.HashMap;
import java.util.Map;

public class putAll
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RenderingHints h1 = new RenderingHints(null);
        h1.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        h1.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        RenderingHints h2 = new RenderingHints(null);
        h2.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        h2.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        h1.putAll((Map<?, ?>)h2);
        harness.check(h1.size() == 3);
        harness.check(h1.containsKey(RenderingHints.KEY_RENDERING));
        harness.check(h1.get(RenderingHints.KEY_TEXT_ANTIALIASING).equals(RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        HashMap<Object, String> m = new HashMap<Object, String>();
        m.put("A", "B");
        boolean pass = false;
        try {
            h1.putAll((Map<?, ?>)m);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        catch (ClassCastException e) {
            pass = true;
        }
        harness.check(pass);
        m.clear();
        m.put(RenderingHints.KEY_DITHERING, null);
        pass = false;
        try {
            h1.putAll((Map<?, ?>)m);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        m.clear();
        m.put(new Integer(1), null);
        pass = false;
        try {
            h1.putAll((Map<?, ?>)m);
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
            h1.putAll((Map<?, ?>)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

