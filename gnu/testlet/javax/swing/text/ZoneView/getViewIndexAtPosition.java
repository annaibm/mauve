/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.ZoneView;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.ZoneView.TestZoneView;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;

public class getViewIndexAtPosition
implements Testlet {
    @Override
    public void test(TestHarness h) {
        PlainDocument doc = new PlainDocument();
        try {
            doc.insertString(0, "0123456789", null);
        }
        catch (BadLocationException ex) {
            RuntimeException rte = new RuntimeException();
            rte.initCause(ex);
            throw rte;
        }
        Element el = doc.getDefaultRootElement();
        TestZoneView zv = new TestZoneView(el, 0);
        zv.append(zv.createZone(0, 3));
        zv.append(zv.createZone(3, 7));
        zv.append(zv.createZone(7, 10));
        h.check(zv.getViewIndexAtPosition(-100), -1);
        h.check(zv.getViewIndexAtPosition(-1), -1);
        h.check(zv.getViewIndexAtPosition(0), 0);
        h.check(zv.getViewIndexAtPosition(2), 0);
        h.check(zv.getViewIndexAtPosition(3), 1);
        h.check(zv.getViewIndexAtPosition(6), 1);
        h.check(zv.getViewIndexAtPosition(7), 2);
        h.check(zv.getViewIndexAtPosition(9), 2);
        h.check(zv.getViewIndexAtPosition(10), -1);
        h.check(zv.getViewIndexAtPosition(11), -1);
        h.check(zv.getViewIndexAtPosition(100), -1);
    }
}

