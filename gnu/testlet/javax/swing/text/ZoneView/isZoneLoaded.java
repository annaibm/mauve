/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.ZoneView;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.ZoneView.TestView;
import gnu.testlet.javax.swing.text.ZoneView.TestZoneView;

public class isZoneLoaded
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TestZoneView zv = new TestZoneView();
        TestView v = new TestView();
        h.check(zv.isZoneLoaded(v), false);
        TestView child = new TestView();
        v.append(child);
        h.check(zv.isZoneLoaded(v), true);
    }
}

