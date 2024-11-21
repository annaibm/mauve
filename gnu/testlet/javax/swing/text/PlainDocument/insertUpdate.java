/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.PlainDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;

public class insertUpdate
implements Testlet {
    DocumentEvent ev;

    @Override
    public void test(TestHarness harness) {
        this.test01(harness);
        this.test02(harness);
        this.test03(harness);
    }

    private void test01(TestHarness h) {
        h.checkPoint("test01");
        PlainDocument doc = new PlainDocument();
        doc.addDocumentListener(new TestListener());
        try {
            doc.insertString(0, "abcde\nabcdef\nabcde\n", null);
            doc.insertString(15, "abcdefghijklmn\n", null);
        }
        catch (BadLocationException ex) {
            h.fail("Unexpected BadLocationException");
        }
        DocumentEvent.ElementChange change = this.ev.getChange(doc.getDefaultRootElement());
        h.check(change.getIndex(), 2);
        Element[] added = change.getChildrenAdded();
        h.check(added.length, 2);
        h.check(added[0].getStartOffset(), 13);
        h.check(added[0].getEndOffset(), 30);
        h.check(added[1].getStartOffset(), 30);
        h.check(added[1].getEndOffset(), 34);
        Element[] removed = change.getChildrenRemoved();
        h.check(removed.length, 1);
        h.check(removed[0].getStartOffset(), 13);
        h.check(removed[0].getEndOffset(), 34);
    }

    private void test02(TestHarness h) {
        h.checkPoint("test02");
        PlainDocument doc = new PlainDocument();
        doc.addDocumentListener(new TestListener());
        try {
            doc.insertString(0, "abcde\nabcdef\nabcde\n", null);
            doc.insertString(13, "\nabc", null);
        }
        catch (BadLocationException ex) {
            h.fail("Unexpected BadLocationException");
        }
        DocumentEvent.ElementChange change = this.ev.getChange(doc.getDefaultRootElement());
        h.check(change.getIndex(), 1);
        Element[] added = change.getChildrenAdded();
        h.check(added.length, 3);
        h.check(added[0].getStartOffset(), 6);
        h.check(added[0].getEndOffset(), 13);
        h.check(added[1].getStartOffset(), 13);
        h.check(added[1].getEndOffset(), 14);
        h.check(added[2].getStartOffset(), 14);
        h.check(added[2].getEndOffset(), 23);
        Element[] removed = change.getChildrenRemoved();
        h.check(removed.length, 2);
        h.check(removed[0].getStartOffset(), 6);
        h.check(removed[0].getEndOffset(), 17);
        h.check(removed[1].getStartOffset(), 17);
        h.check(removed[1].getEndOffset(), 23);
    }

    private void test03(TestHarness h) {
        h.checkPoint("test03");
        PlainDocument doc = new PlainDocument();
        doc.addDocumentListener(new TestListener());
        try {
            doc.insertString(0, "abcd", null);
            doc.insertString(0, "abcde\nabcdef\nabcde\n", null);
        }
        catch (BadLocationException ex) {
            h.fail("Unexpected BadLocationException");
        }
        DocumentEvent.ElementChange change = this.ev.getChange(doc.getDefaultRootElement());
        h.check(change.getIndex(), 0);
        Element[] added = change.getChildrenAdded();
        h.check(added.length, 4);
        h.check(added[0].getStartOffset(), 0);
        h.check(added[0].getEndOffset(), 6);
        h.check(added[1].getStartOffset(), 6);
        h.check(added[1].getEndOffset(), 13);
        h.check(added[2].getStartOffset(), 13);
        h.check(added[2].getEndOffset(), 19);
        h.check(added[3].getStartOffset(), 19);
        h.check(added[3].getEndOffset(), 24);
        Element[] removed = change.getChildrenRemoved();
        h.check(removed.length, 1);
        h.check(removed[0].getStartOffset(), 0);
        h.check(removed[0].getEndOffset(), 24);
    }

    private class TestListener
    implements DocumentListener {
        private TestListener() {
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            insertUpdate.this.ev = e;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            insertUpdate.this.ev = e;
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            insertUpdate.this.ev = e;
        }
    }
}

