/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.DefaultStyledDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class insertString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testInsertEqualAttributes(harness);
        this.testInsertModifiedAttributes(harness);
        this.testInsertNewline(harness);
    }

    void testInsertEqualAttributes(TestHarness harness) {
        harness.checkPoint("insertEqualAttributes");
        DefaultStyledDocument doc = new DefaultStyledDocument();
        this.prepareDocument(doc);
        SimpleAttributeSet atts = new SimpleAttributeSet();
        try {
            doc.insertString(5, "12345", atts);
        }
        catch (BadLocationException ex) {
            harness.debug(ex);
        }
        Element root = doc.getDefaultRootElement();
        harness.check(root.getStartOffset(), 0);
        harness.check(root.getEndOffset(), 21);
        harness.check(root.getElementCount(), 1);
        Element par = root.getElement(0);
        harness.check(par.getStartOffset(), 0);
        harness.check(par.getEndOffset(), 21);
        harness.check(par.getElementCount(), 1);
        Element child1 = par.getElement(0);
        harness.check(child1.getStartOffset(), 0);
        harness.check(child1.getEndOffset(), 21);
    }

    void testInsertModifiedAttributes(TestHarness harness) {
        harness.checkPoint("insertModifiedAttributes");
        DefaultStyledDocument doc = new DefaultStyledDocument();
        this.prepareDocument(doc);
        SimpleAttributeSet atts = new SimpleAttributeSet();
        StyleConstants.setForeground(atts, Color.RED);
        try {
            doc.insertString(5, "12345", atts);
        }
        catch (BadLocationException ex) {
            harness.debug(ex);
        }
        Element root = doc.getDefaultRootElement();
        harness.check(root.getStartOffset(), 0);
        harness.check(root.getEndOffset(), 21);
        harness.check(root.getElementCount(), 1);
        Element par = root.getElement(0);
        harness.check(par.getStartOffset(), 0);
        harness.check(par.getEndOffset(), 21);
        harness.check(par.getElementCount(), 3);
        Element child1 = par.getElement(0);
        harness.check(child1.getStartOffset(), 0);
        harness.check(child1.getEndOffset(), 5);
        Element child2 = par.getElement(1);
        harness.check(child2.getStartOffset(), 5);
        harness.check(child2.getEndOffset(), 10);
        Element child3 = par.getElement(2);
        harness.check(child3.getStartOffset(), 10);
        harness.check(child3.getEndOffset(), 21);
    }

    void testInsertNewline(TestHarness harness) {
        harness.checkPoint("insertNewline");
        DefaultStyledDocument doc = new DefaultStyledDocument();
        this.prepareDocument(doc);
        SimpleAttributeSet atts = new SimpleAttributeSet();
        try {
            doc.insertString(5, "abcde\nfghij", atts);
        }
        catch (BadLocationException ex) {
            harness.debug(ex);
        }
        Element root = doc.getDefaultRootElement();
        harness.check(root.getStartOffset(), 0);
        harness.check(root.getEndOffset(), 27);
        harness.check(root.getElementCount(), 2);
        Element par1 = root.getElement(0);
        harness.check(par1.getStartOffset(), 0);
        harness.check(par1.getEndOffset(), 11);
        harness.check(par1.getElementCount(), 1);
        Element par2 = root.getElement(1);
        harness.check(par2.getStartOffset(), 11);
        harness.check(par2.getEndOffset(), 27);
        harness.check(par2.getElementCount(), 1);
    }

    void prepareDocument(DefaultStyledDocument doc) {
        try {
            doc.insertString(0, "abcdefghijklmno", new SimpleAttributeSet());
        }
        catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
}

