/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.PlainDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.PlainDocument;
import javax.swing.text.Position;
import javax.swing.text.SimpleAttributeSet;

public class insertString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testNewline(harness);
        this.testFilterNewline(harness);
        this.testArguments(harness);
        this.testPositions(harness);
        this.testModifications(harness);
    }

    private void testNewline(TestHarness harness) {
        harness.checkPoint("testNewline");
        PlainDocument doc = new PlainDocument();
        try {
            doc.insertString(0, "Hello\nWorld", new SimpleAttributeSet());
        }
        catch (BadLocationException ex) {
            harness.fail("BadLocationException");
        }
        Element root = doc.getRootElements()[0];
        harness.check(root instanceof AbstractDocument.BranchElement);
        harness.check(root.getElementCount(), 2);
        Element el1 = root.getElement(0);
        harness.check(el1 instanceof AbstractDocument.LeafElement);
        harness.check(el1.getStartOffset(), 0);
        harness.check(el1.getEndOffset(), 6);
        Element el2 = root.getElement(1);
        harness.check(el2 instanceof AbstractDocument.LeafElement);
        harness.check(el2.getStartOffset(), 6);
        harness.check(el2.getEndOffset(), 12);
    }

    private void testFilterNewline(TestHarness harness) {
        harness.checkPoint("testFilterNewline");
        PlainDocument doc = new PlainDocument();
        doc.putProperty("filterNewlines", Boolean.TRUE);
        try {
            doc.insertString(0, "Hello\nWorld", new SimpleAttributeSet());
        }
        catch (BadLocationException ex) {
            harness.fail("BadLocationException");
        }
        Element root = doc.getRootElements()[0];
        harness.check(root instanceof AbstractDocument.BranchElement);
        harness.check(root.getElementCount(), 1);
        Element el1 = root.getElement(0);
        harness.check(el1 instanceof AbstractDocument.LeafElement);
        harness.check(el1.getStartOffset(), 0);
        harness.check(el1.getEndOffset(), 12);
    }

    public void testArguments(TestHarness harness) {
        harness.checkPoint("testArguments");
        PlainDocument d = new PlainDocument();
        boolean pass = false;
        try {
            d.insertString(-1, "XYZ", SimpleAttributeSet.EMPTY);
        }
        catch (Exception e) {
            pass = e instanceof BadLocationException;
        }
        harness.check(pass);
        pass = false;
        try {
            d.insertString(2, "XYZ", SimpleAttributeSet.EMPTY);
        }
        catch (BadLocationException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            d.insertString(0, null, SimpleAttributeSet.EMPTY);
        }
        catch (Exception e) {
            pass = false;
        }
        harness.check(pass);
        pass = true;
        try {
            d.insertString(0, "ABC", null);
        }
        catch (Exception e) {
            pass = false;
        }
        harness.check(pass);
    }

    public void testPositions(TestHarness harness) {
        harness.checkPoint("testPositions");
        PlainDocument d = new PlainDocument();
        try {
            d.insertString(0, "ABC", null);
            Position p0 = d.createPosition(0);
            harness.check(p0.getOffset(), 0);
            Position p1 = d.createPosition(1);
            harness.check(p1.getOffset(), 1);
            Position p2 = d.createPosition(3);
            harness.check(p2.getOffset(), 3);
            Position p3 = d.createPosition(4);
            harness.check(p3.getOffset(), 4);
            d.insertString(1, "XYZ", null);
            harness.check(p0.getOffset(), 0);
            harness.check(p1.getOffset(), 4);
            harness.check(p2.getOffset(), 6);
            harness.check(p3.getOffset(), 7);
            d.remove(2, 3);
            harness.check(p0.getOffset(), 0);
            harness.check(p1.getOffset(), 2);
            harness.check(p2.getOffset(), 3);
            harness.check(p3.getOffset(), 4);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
    }

    PlainDocument prepare(String initialContent) {
        PlainDocument pd = new PlainDocument();
        try {
            pd.insertString(0, initialContent, null);
            return pd;
        }
        catch (BadLocationException ble) {
            return pd;
        }
    }

    void checkElement(TestHarness harness, PlainDocument doc, int elementIndex, int startOffset, int endOffset, String text2) {
        Element e = doc.getDefaultRootElement();
        Element child = e.getElement(elementIndex);
        harness.check(child.getStartOffset(), startOffset);
        harness.check(child.getEndOffset(), endOffset);
        String retrievedText = null;
        try {
            retrievedText = doc.getText(startOffset, endOffset - startOffset);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        harness.check(retrievedText, (Object)text2);
    }

    void insert(PlainDocument doc, int index, String text2) {
        try {
            doc.insertString(index, text2, null);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
    }

    void testModifications(TestHarness h) {
        h.checkPoint("modifications-insert char 1-pre");
        PlainDocument doc = new PlainDocument();
        this.checkElement(h, doc, 0, 0, 1, "\n");
        h.checkPoint("modifications-insert char 1-post");
        this.insert(doc, 0, "a");
        this.checkElement(h, doc, 0, 0, 2, "a\n");
        h.checkPoint("modifications-insert newline 1-pre");
        doc = this.prepare("abc\nbla\n");
        this.checkElement(h, doc, 0, 0, 4, "abc\n");
        this.checkElement(h, doc, 1, 4, 8, "bla\n");
        h.checkPoint("modifications-insert newline 1-post");
        this.insert(doc, 1, "\n");
        this.checkElement(h, doc, 0, 0, 2, "a\n");
        this.checkElement(h, doc, 1, 2, 5, "bc\n");
        this.checkElement(h, doc, 2, 5, 9, "bla\n");
        h.checkPoint("modifications-insert newline 2-pre");
        doc = this.prepare("abc\nbla\n");
        this.checkElement(h, doc, 0, 0, 4, "abc\n");
        h.checkPoint("modifications-insert newline 2-post");
        this.insert(doc, 3, "\n");
        this.checkElement(h, doc, 0, 0, 4, "abc\n");
        this.checkElement(h, doc, 1, 4, 5, "\n");
        h.checkPoint("modifications-insert char 2-pre");
        doc = this.prepare("abc\n");
        this.checkElement(h, doc, 0, 0, 4, "abc\n");
        h.checkPoint("modifications-insert char 2-post");
        this.insert(doc, 4, "d");
        this.checkElement(h, doc, 0, 0, 4, "abc\n");
        this.checkElement(h, doc, 1, 4, 6, "d\n");
        h.checkPoint("modifications-insert multi-line string 1-pre");
        doc = this.prepare("abc\ndef\n");
        this.checkElement(h, doc, 0, 0, 4, "abc\n");
        this.checkElement(h, doc, 1, 4, 8, "def\n");
        h.checkPoint("modifications-insert multi-line string 1-post");
        this.insert(doc, 2, "foo\nbaz\nbar");
        this.checkElement(h, doc, 0, 0, 6, "abfoo\n");
        this.checkElement(h, doc, 1, 6, 10, "baz\n");
        this.checkElement(h, doc, 2, 10, 15, "barc\n");
        this.checkElement(h, doc, 3, 15, 19, "def\n");
        h.checkPoint("modifications-insert single-line string-pre");
        doc = this.prepare("abc\ndef\n");
        this.checkElement(h, doc, 0, 0, 4, "abc\n");
        this.checkElement(h, doc, 1, 4, 8, "def\n");
        h.checkPoint("modifications-insert single-line string-post");
        this.insert(doc, 4, "foo");
        this.checkElement(h, doc, 0, 0, 4, "abc\n");
        this.checkElement(h, doc, 1, 4, 11, "foodef\n");
        h.checkPoint("modifications-insert multi-line string 2-pre");
        doc = this.prepare("abc\ndef\n");
        this.checkElement(h, doc, 0, 0, 4, "abc\n");
        this.checkElement(h, doc, 1, 4, 8, "def\n");
        h.checkPoint("modifications-insert multi-line string 2-post");
        this.insert(doc, 4, "foo\nbaz\nbar");
        this.checkElement(h, doc, 0, 0, 4, "abc\n");
        this.checkElement(h, doc, 1, 4, 8, "foo\n");
        this.checkElement(h, doc, 2, 8, 12, "baz\n");
        this.checkElement(h, doc, 3, 12, 19, "bardef\n");
        h.checkPoint("modifications-insert char 3-pre");
        doc = this.prepare("ac\n");
        this.checkElement(h, doc, 0, 0, 3, "ac\n");
        h.checkPoint("modifications-insert char 3-post");
        this.insert(doc, 1, "b");
        this.checkElement(h, doc, 0, 0, 4, "abc\n");
        h.checkPoint("modifications-multi-insert-1");
        doc = this.prepare("abc\ndef\n");
        this.checkElement(h, doc, 0, 0, 4, "abc\n");
        this.checkElement(h, doc, 1, 4, 8, "def\n");
        h.checkPoint("modifications-multi-insert-2");
        this.insert(doc, 3, "---");
        this.checkElement(h, doc, 0, 0, 7, "abc---\n");
        this.checkElement(h, doc, 1, 7, 11, "def\n");
        h.checkPoint("modifications-multi-insert-3");
        this.insert(doc, 7, "---");
        this.checkElement(h, doc, 0, 0, 7, "abc---\n");
        this.checkElement(h, doc, 1, 7, 14, "---def\n");
    }
}

