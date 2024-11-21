/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.ZoneView;

import gnu.testlet.TestHarness;
import gnu.testlet.javax.swing.text.ZoneView.TestZoneView;

public class getMaxZonesLoaded {
    public void test(TestHarness h) {
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
        h.check(zv.getMaxZonesLoaded(), Integer.MAX_VALUE);
        try {
            zv.setMaxZonesLoaded(Integer.MIN_VALUE);
            h.fail("Should have thrown IllegalArgumentException");
        }
        catch (IllegalArgumentException ex) {
            h.check(true);
        }
        h.check(zv.getMaxZonesLoaded(), Integer.MAX_VALUE);
    }
}

