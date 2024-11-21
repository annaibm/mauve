/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.ZoneView;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.ZoneView.TestView;
import gnu.testlet.javax.swing.text.ZoneView.TestZoneView;

public class unloadZone
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TestZoneView zv = new TestZoneView();
        TestView v = new TestView();
        v.removeAllCalled = false;
        zv.unloadZone(v);
        h.check(v.removeAllCalled, true);
        try {
            zv.unloadZone(null);
            h.fail("NullPointerException should be thrown");
        }
        catch (NullPointerException ex) {
            h.check(true);
        }
    }
}

