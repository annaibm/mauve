/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.RenderingHints;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.RenderingHints;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("RenderingHints(Map)");
        this.testConstructor1(harness);
        harness.checkPoint("RenderingHints(Key, Object)");
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        RenderingHints h = new RenderingHints(null);
        harness.check(h.isEmpty());
        harness.check(h.size(), 0);
    }

    public void testConstructor2(TestHarness harness) {
        boolean pass = false;
        try {
            RenderingHints renderingHints = new RenderingHints(null, RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            RenderingHints e = new RenderingHints(RenderingHints.KEY_ALPHA_INTERPOLATION, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

