/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.ZoneView;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import javax.swing.text.ZoneView;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testSimple(harness);
        this.testDefaultValues(harness);
    }

    private void testSimple(TestHarness h) {
        PlainDocument doc = new PlainDocument();
        Element el = doc.getDefaultRootElement();
        ZoneView zv = new ZoneView(el, 0);
        h.check(zv.getAxis(), 0);
        h.check(zv.getElement(), el);
        zv = new ZoneView(el, 1);
        h.check(zv.getAxis(), 1);
        h.check(zv.getElement(), el);
    }

    private void testDefaultValues(TestHarness h) {
        PlainDocument doc = new PlainDocument();
        Element el = doc.getDefaultRootElement();
        ZoneView zv = new ZoneView(el, 0);
        h.check(zv.getMaximumZoneSize(), 8192);
        h.check(zv.getMaxZonesLoaded(), 3);
    }
}

