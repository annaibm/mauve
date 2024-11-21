/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.ZoneView;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.ZoneView.TestView;
import gnu.testlet.javax.swing.text.ZoneView.TestZoneView;

public class zoneWasLoaded
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TestZoneView zv = new TestZoneView();
        zv.setMaxZonesLoaded(3);
        TestView v1 = new TestView();
        zv.lastUnloadedZones.clear();
        zv.zoneWasLoaded(v1);
        h.check(zv.lastUnloadedZones.size(), 0);
        TestView v2 = new TestView();
        zv.zoneWasLoaded(v2);
        h.check(zv.lastUnloadedZones.size(), 0);
        TestView v3 = new TestView();
        zv.zoneWasLoaded(v3);
        h.check(zv.lastUnloadedZones.size(), 0);
        TestView v4 = new TestView();
        zv.zoneWasLoaded(v4);
        h.check(zv.lastUnloadedZones.size(), 1);
        h.check(zv.lastUnloadedZones.remove(0), v1);
        TestView v5 = new TestView();
        zv.zoneWasLoaded(v5);
        h.check(zv.lastUnloadedZones.size(), 1);
        h.check(zv.lastUnloadedZones.remove(0), v2);
        TestView v6 = new TestView();
        zv.zoneWasLoaded(v6);
        h.check(zv.lastUnloadedZones.size(), 1);
        h.check(zv.lastUnloadedZones.remove(0), v3);
        try {
            zv.zoneWasLoaded(null);
            zv.zoneWasLoaded(null);
            zv.zoneWasLoaded(null);
            h.check(true);
        }
        catch (NullPointerException ex) {
            h.fail("No NullPointerException should be thrown");
        }
        try {
            zv.zoneWasLoaded(v1);
            h.fail("NullPointerException should be thrown");
        }
        catch (NullPointerException ex) {
            h.check(true);
        }
    }
}

