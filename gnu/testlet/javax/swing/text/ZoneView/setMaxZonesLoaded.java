/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.ZoneView;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.ZoneView.TestView;
import gnu.testlet.javax.swing.text.ZoneView.TestZoneView;

public class setMaxZonesLoaded
implements Testlet {
    @Override
    public void test(TestHarness h) {
        this.testSimple(h);
        this.testUnloading(h);
    }

    private void testSimple(TestHarness h) {
        TestZoneView zv = new TestZoneView();
        zv.setMaxZonesLoaded(1);
        h.check(zv.getMaxZonesLoaded(), 1);
        zv.setMaxZonesLoaded(Integer.MAX_VALUE);
        h.check(zv.getMaxZonesLoaded(), Integer.MAX_VALUE);
        try {
            zv.setMaxZonesLoaded(0);
            h.fail("Should have thrown IllegalArgumentException");
        }
        catch (IllegalArgumentException ex) {
            h.check(true);
        }
        try {
            zv.setMaxZonesLoaded(Integer.MIN_VALUE);
            h.fail("Should have thrown IllegalArgumentException");
        }
        catch (IllegalArgumentException ex) {
            h.check(true);
        }
    }

    private void testUnloading(TestHarness h) {
        TestZoneView zv = new TestZoneView();
        zv.setMaxZonesLoaded(4);
        TestView v1 = new TestView();
        zv.zoneWasLoaded(v1);
        TestView v2 = new TestView();
        zv.zoneWasLoaded(v2);
        TestView v3 = new TestView();
        zv.zoneWasLoaded(v3);
        TestView v4 = new TestView();
        zv.zoneWasLoaded(v4);
        h.check(zv.lastUnloadedZones.size(), 0);
        zv.setMaxZonesLoaded(2);
        h.check(zv.lastUnloadedZones.size(), 2);
        h.check(zv.lastUnloadedZones.remove(0), v1);
        h.check(zv.lastUnloadedZones.remove(0), v2);
        zv.setMaxZonesLoaded(4);
        h.check(zv.lastUnloadedZones.size(), 0);
        zv.setMaxZonesLoaded(1);
        h.check(zv.lastUnloadedZones.size(), 1);
        h.check(zv.lastUnloadedZones.remove(0), v3);
    }
}

