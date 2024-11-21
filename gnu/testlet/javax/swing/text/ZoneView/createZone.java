/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.ZoneView;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.ZoneView.TestZoneView;
import javax.swing.text.AsyncBoxView;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import javax.swing.text.View;

public class createZone
implements Testlet {
    @Override
    public void test(TestHarness h) {
        PlainDocument doc = new PlainDocument();
        try {
            doc.insertString(0, "123456789", null);
        }
        catch (BadLocationException ex) {
            RuntimeException rte = new RuntimeException();
            rte.initCause(ex);
            throw rte;
        }
        Element el = doc.getDefaultRootElement();
        TestZoneView zv = new TestZoneView(el, 0);
        View zone = zv.createZone(0, 9);
        h.check(zone instanceof AsyncBoxView);
        h.check(zone.getStartOffset(), 0);
        h.check(zone.getEndOffset(), 9);
        try {
            doc.insertString(5, "abcde", null);
        }
        catch (BadLocationException ex) {
            RuntimeException rte = new RuntimeException();
            rte.initCause(ex);
            throw rte;
        }
        h.check(zone.getStartOffset(), 0);
        h.check(zone.getEndOffset(), 14);
        zone = zv.createZone(-10, 23);
    }
}

