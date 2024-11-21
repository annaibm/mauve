/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.ZoneView;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.ZoneView.TestZoneView;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import javax.swing.text.View;

public class loadChildren
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testSimple(harness);
        this.testOversize(harness);
    }

    private void testSimple(TestHarness h) {
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
        TestZoneView zv = new TestZoneView(el, 1);
        zv.loadChildren(zv.getViewFactory());
        h.check(zv.getViewCount(), 1);
        View child = zv.getView(0);
        h.check(child.getStartOffset(), 0);
        h.check(child.getEndOffset(), el.getEndOffset());
    }

    private void testOversize(TestHarness h) {
        PlainDocument doc = new PlainDocument();
        try {
            doc.insertString(0, "0123456789", null);
        }
        catch (BadLocationException ex) {
            RuntimeException rte = new RuntimeException();
            rte.initCause(ex);
            throw rte;
        }
        AbstractDocument.BranchElement el = (AbstractDocument.BranchElement)doc.getDefaultRootElement();
        PlainDocument plainDocument = doc;
        plainDocument.getClass();
        AbstractDocument.LeafElement el1 = new AbstractDocument.LeafElement(plainDocument, el, null, 0, 3);
        PlainDocument plainDocument2 = doc;
        plainDocument2.getClass();
        AbstractDocument.LeafElement el2 = new AbstractDocument.LeafElement(plainDocument2, el, null, 3, 7);
        PlainDocument plainDocument3 = doc;
        plainDocument3.getClass();
        AbstractDocument.LeafElement el3 = new AbstractDocument.LeafElement(plainDocument3, el, null, 7, 11);
        el.replace(0, 1, new Element[]{el1, el2, el3});
        TestZoneView zv = new TestZoneView(el, 1);
        zv.setMaximumZoneSize(5);
        zv.loadChildren(zv.getViewFactory());
        h.check(zv.getViewCount(), 3);
        View child = zv.getView(0);
        h.check(child.getStartOffset(), 0);
        h.check(child.getEndOffset(), 3);
        child = zv.getView(1);
        h.check(child.getStartOffset(), 3);
        h.check(child.getEndOffset(), 7);
        child = zv.getView(2);
        h.check(child.getStartOffset(), 7);
        h.check(child.getEndOffset(), 11);
    }
}

