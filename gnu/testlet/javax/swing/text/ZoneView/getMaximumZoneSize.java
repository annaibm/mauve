/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.ZoneView;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.ZoneView.TestZoneView;

public class getMaximumZoneSize
implements Testlet {
    @Override
    public void test(TestHarness h) {
        TestZoneView zv = new TestZoneView();
        h.check(zv.getMaximumZoneSize(), 8192);
        zv.setMaximumZoneSize(0);
        h.check(zv.getMaximumZoneSize(), 0);
        zv.setMaximumZoneSize(1);
        h.check(zv.getMaximumZoneSize(), 1);
        zv.setMaximumZoneSize(Integer.MAX_VALUE);
        h.check(zv.getMaximumZoneSize(), Integer.MAX_VALUE);
        zv.setMaximumZoneSize(Integer.MIN_VALUE);
        h.check(zv.getMaximumZoneSize(), Integer.MIN_VALUE);
    }
}

