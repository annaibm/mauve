/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.DefaultStyledDocument.ElementBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.EmptyStackException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;

public class insert
implements Testlet,
DocumentListener {
    private DocumentEvent documentEvent;

    @Override
    public void test(TestHarness harness) {
        this.testOriginate1(harness);
        this.testOriginate2(harness);
        this.testOriginate3(harness);
        this.testJoinPrevious1(harness);
        this.testJoinPrevious2(harness);
        this.testJoinPrevious3(harness);
        this.testJoinNext1(harness);
        this.testJoinNext2(harness);
        this.testJoinNext3(harness);
        this.testEndTag1(harness);
        this.testEndTag2(harness);
        this.testEndTag3(harness);
        this.testEndTag4(harness);
        this.testEndTag5(harness);
        this.testNewlines(harness);
        this.testNewlines2(harness);
    }

    private void testOriginate1(TestHarness h) {
        h.checkPoint("testOriginate1");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        Element root = doc.getDefaultRootElement();
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 3);
        doc.insert(5, specs);
        root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 1);
        par = root.getElement(0);
        h.check(par.getElementCount(), 4);
        Element el1 = par.getElement(0);
        h.check(el1.getStartOffset(), 0);
        h.check(el1.getEndOffset(), 5);
        Element el2 = par.getElement(1);
        h.check(el2.getStartOffset(), 5);
        h.check(el2.getEndOffset(), 10);
        Element el3 = par.getElement(2);
        h.check(el3.getStartOffset(), 10);
        h.check(el3.getEndOffset(), 15);
        DocumentEvent.ElementChange ec = this.documentEvent.getChange(root);
        h.check(ec, null);
        ec = this.documentEvent.getChange(par);
        h.check(ec.getChildrenAdded().length, 2);
        h.check(ec.getChildrenRemoved().length, 1);
        h.check(ec.getIndex(), 0);
    }

    private void testOriginate2(TestHarness h) {
        h.checkPoint("testOriginate2");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        doc.insert(2, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 1);
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 5);
        Element el1 = par.getElement(0);
        h.check(el1.getStartOffset(), 0);
        h.check(el1.getEndOffset(), 2);
        Element el2 = par.getElement(1);
        h.check(el2.getStartOffset(), 2);
        h.check(el2.getEndOffset(), 7);
        Element el3 = par.getElement(2);
        h.check(el3.getStartOffset(), 7);
        h.check(el3.getEndOffset(), 10);
        Element el4 = par.getElement(3);
        h.check(el4.getStartOffset(), 10);
        h.check(el4.getEndOffset(), 15);
        DocumentEvent.ElementChange ec = this.documentEvent.getChange(root);
        h.check(ec, null);
        ec = this.documentEvent.getChange(par);
        h.check(ec.getChildrenAdded().length, 3);
        h.check(ec.getChildrenRemoved().length, 1);
        h.check(ec.getIndex(), 0);
    }

    private void testOriginate3(TestHarness h) {
        h.checkPoint("testOriginate3");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        doc.insert(7, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 1);
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 5);
        Element el1 = par.getElement(0);
        h.check(el1.getStartOffset(), 0);
        h.check(el1.getEndOffset(), 5);
        Element el2 = par.getElement(1);
        h.check(el2.getStartOffset(), 5);
        h.check(el2.getEndOffset(), 7);
        Element el3 = par.getElement(2);
        h.check(el3.getStartOffset(), 7);
        h.check(el3.getEndOffset(), 12);
        Element el4 = par.getElement(3);
        h.check(el4.getStartOffset(), 12);
        h.check(el4.getEndOffset(), 15);
        DocumentEvent.ElementChange ec = this.documentEvent.getChange(root);
        h.check(ec, null);
        ec = this.documentEvent.getChange(par);
        h.check(ec.getChildrenAdded().length, 3);
        h.check(ec.getChildrenRemoved().length, 1);
        h.check(ec.getIndex(), 1);
    }

    private void testJoinPrevious1(TestHarness h) {
        h.checkPoint("testJoinPrevious1");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        spec.setDirection((short)4);
        this.documentEvent = null;
        doc.insert(5, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 1);
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 3);
        Element el1 = par.getElement(0);
        h.check(el1.getStartOffset(), 0);
        h.check(el1.getEndOffset(), 10);
        Element el2 = par.getElement(1);
        h.check(el2.getStartOffset(), 10);
        h.check(el2.getEndOffset(), 15);
    }

    private void testJoinPrevious2(TestHarness h) {
        h.checkPoint("testJoinPrevious2");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        spec.setDirection((short)4);
        this.documentEvent = null;
        doc.insert(2, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 1);
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 3);
        Element el1 = par.getElement(0);
        h.check(el1.getStartOffset(), 0);
        h.check(el1.getEndOffset(), 10);
        Element el2 = par.getElement(1);
        h.check(el2.getStartOffset(), 10);
        h.check(el2.getEndOffset(), 15);
    }

    private void testJoinPrevious3(TestHarness h) {
        h.checkPoint("testJoinPrevious3");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        spec.setDirection((short)4);
        this.documentEvent = null;
        doc.insert(7, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 1);
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 3);
        Element el1 = par.getElement(0);
        h.check(el1.getStartOffset(), 0);
        h.check(el1.getEndOffset(), 5);
        Element el2 = par.getElement(1);
        h.check(el2.getStartOffset(), 5);
        h.check(el2.getEndOffset(), 15);
    }

    private void testJoinNext1(TestHarness h) {
        h.checkPoint("testJoinNext1");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        spec.setDirection((short)5);
        doc.insert(5, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 1);
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 3);
        Element el1 = par.getElement(0);
        h.check(el1.getStartOffset(), 0);
        h.check(el1.getEndOffset(), 5);
        Element el2 = par.getElement(1);
        h.check(el2.getStartOffset(), 5);
        h.check(el2.getEndOffset(), 15);
        DocumentEvent.ElementChange ec = this.documentEvent.getChange(root);
        h.check(ec, null);
        ec = this.documentEvent.getChange(par);
        h.check(ec.getChildrenAdded().length, 2);
        h.check(ec.getChildrenRemoved().length, 2);
        h.check(ec.getIndex(), 0);
    }

    private void testJoinNext2(TestHarness h) {
        h.checkPoint("testJoinNext2");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        spec.setDirection((short)5);
        doc.insert(2, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 1);
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 3);
        Element el1 = par.getElement(0);
        h.check(el1.getStartOffset(), 0);
        h.check(el1.getEndOffset(), 2);
        Element el2 = par.getElement(1);
        h.check(el2.getStartOffset(), 2);
        h.check(el2.getEndOffset(), 15);
        DocumentEvent.ElementChange ec = this.documentEvent.getChange(root);
        h.check(ec, null);
        ec = this.documentEvent.getChange(par);
        h.check(ec.getChildrenAdded().length, 2);
        h.check(ec.getChildrenRemoved().length, 2);
        h.check(ec.getIndex(), 0);
    }

    private void testJoinNext3(TestHarness h) {
        h.checkPoint("testJoinNext3");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        spec.setDirection((short)5);
        doc.insert(7, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 1);
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 3);
        Element el1 = par.getElement(0);
        h.check(el1.getStartOffset(), 0);
        h.check(el1.getEndOffset(), 5);
        Element el2 = par.getElement(1);
        h.check(el2.getStartOffset(), 5);
        h.check(el2.getEndOffset(), 7);
        Element el3 = par.getElement(2);
        h.check(el3.getStartOffset(), 7);
        h.check(el3.getEndOffset(), 16);
        DocumentEvent.ElementChange ec = this.documentEvent.getChange(root);
        h.check(ec, null);
        ec = this.documentEvent.getChange(par);
        h.check(ec.getChildrenAdded().length, 2);
        h.check(ec.getChildrenRemoved().length, 2);
        h.check(ec.getIndex(), 1);
    }

    private void testEndTag1(TestHarness h) {
        h.checkPoint("testEndTag1");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        spec = new DefaultStyledDocument.ElementSpec(atts, 2);
        specs = new DefaultStyledDocument.ElementSpec[]{spec, spec, spec};
        this.documentEvent = null;
        doc.insert(7, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 1);
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 3);
        Element el1 = par.getElement(0);
        h.check(el1.getStartOffset(), 0);
        h.check(el1.getEndOffset(), 5);
        Element el2 = par.getElement(1);
        h.check(el2.getStartOffset(), 5);
        h.check(el2.getEndOffset(), 10);
        Element el3 = par.getElement(2);
        h.check(el3.getStartOffset(), 10);
        h.check(el3.getEndOffset(), 11);
        h.check(this.documentEvent, null);
    }

    private void testEndTag2(TestHarness h) {
        h.checkPoint("testEndTag2");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        DefaultStyledDocument.ElementSpec spec1 = new DefaultStyledDocument.ElementSpec(atts, 2);
        DefaultStyledDocument.ElementSpec spec2 = new DefaultStyledDocument.ElementSpec(atts, 1);
        specs = new DefaultStyledDocument.ElementSpec[]{spec1, spec1, spec1, spec2};
        this.documentEvent = null;
        doc.insert(7, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 1);
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 3);
        Element el1 = par.getElement(0);
        h.check(el1.getStartOffset(), 0);
        h.check(el1.getEndOffset(), 5);
        Element el2 = par.getElement(1);
        h.check(el2.getStartOffset(), 5);
        h.check(el2.getEndOffset(), 10);
        Element el3 = par.getElement(2);
        h.check(el3.getStartOffset(), 10);
        h.check(el3.getEndOffset(), 11);
        h.check(this.documentEvent, null);
    }

    private void testEndTag3(TestHarness h) {
        h.checkPoint("testEndTag3");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        DefaultStyledDocument.ElementSpec spec1 = new DefaultStyledDocument.ElementSpec(atts, 2);
        specs = new DefaultStyledDocument.ElementSpec[]{spec1, spec1, spec};
        this.documentEvent = null;
        try {
            doc.insert(7, specs);
            h.fail("EmptyStackException must be thrown");
        }
        catch (EmptyStackException ex) {
            h.check(true);
        }
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 1);
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 3);
        Element el1 = par.getElement(0);
        h.check(el1.getStartOffset(), 0);
        h.check(el1.getEndOffset(), 5);
        Element el2 = par.getElement(1);
        h.check(el2.getStartOffset(), 5);
        h.check(el2.getEndOffset(), 15);
        Element el3 = par.getElement(2);
        h.check(el3.getStartOffset(), 15);
        h.check(el3.getEndOffset(), 16);
        h.check(this.documentEvent, null);
    }

    private void testEndTag4(TestHarness h) {
        h.checkPoint("testEndTag4");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        DefaultStyledDocument.ElementSpec spec1 = new DefaultStyledDocument.ElementSpec(atts, 2);
        specs = new DefaultStyledDocument.ElementSpec[]{spec1, spec};
        this.documentEvent = null;
        doc.insert(7, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 3);
        Element par1 = root.getElement(0);
        h.check(par1.getElementCount(), 2);
        Element el = par1.getElement(0);
        h.check(el.getStartOffset(), 0);
        h.check(el.getEndOffset(), 5);
        el = par1.getElement(1);
        h.check(el.getStartOffset(), 5);
        h.check(el.getEndOffset(), 7);
        el = root.getElement(1);
        h.check(el.getElementCount(), 0);
        h.check(el.getStartOffset(), 7);
        h.check(el.getEndOffset(), 12);
        Element par2 = root.getElement(2);
        h.check(par2.getElementCount(), 2);
        el = par2.getElement(0);
        h.check(el.getStartOffset(), 12);
        h.check(el.getEndOffset(), 15);
        el = par2.getElement(1);
        h.check(el.getStartOffset(), 15);
        h.check(el.getEndOffset(), 16);
        DocumentEvent.ElementChange ec = this.documentEvent.getChange(root);
        h.check(ec.getChildrenRemoved().length, 0);
        h.check(ec.getChildrenAdded().length, 2);
        h.check(ec.getIndex(), 1);
        ec = this.documentEvent.getChange(par1);
        h.check(ec.getChildrenRemoved().length, 2);
        h.check(ec.getChildrenAdded().length, 1);
        h.check(ec.getIndex(), 1);
        ec = this.documentEvent.getChange(par2);
        h.check(ec, null);
    }

    private void testEndTag5(TestHarness h) {
        h.checkPoint("testEndTag5");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'H', 'e', 'l', 'l', 'o'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec spec = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 5);
        spec.setDirection((short)6);
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{spec};
        doc.insert(0, specs);
        doc.insert(5, specs);
        DefaultStyledDocument.ElementSpec spec1 = new DefaultStyledDocument.ElementSpec(atts, 2);
        DefaultStyledDocument.ElementSpec spec2 = new DefaultStyledDocument.ElementSpec(atts, 1);
        specs = new DefaultStyledDocument.ElementSpec[]{spec, spec1, spec2};
        this.documentEvent = null;
        doc.insert(5, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 2);
        Element par1 = root.getElement(0);
        h.check(par1.getElementCount(), 2);
        Element el = par1.getElement(0);
        h.check(el.getStartOffset(), 0);
        h.check(el.getEndOffset(), 5);
        el = par1.getElement(1);
        h.check(el.getStartOffset(), 5);
        h.check(el.getEndOffset(), 10);
        Element par2 = root.getElement(1);
        h.check(par2.getElementCount(), 2);
        el = par2.getElement(0);
        h.check(el.getStartOffset(), 10);
        h.check(el.getEndOffset(), 15);
        el = par2.getElement(1);
        h.check(el.getStartOffset(), 15);
        h.check(el.getEndOffset(), 16);
        DocumentEvent.ElementChange ec = this.documentEvent.getChange(root);
        h.check(ec.getChildrenRemoved().length, 0);
        h.check(ec.getChildrenAdded().length, 1);
        h.check(ec.getIndex(), 1);
        ec = this.documentEvent.getChange(par1);
        h.check(ec.getChildrenRemoved().length, 3);
        h.check(ec.getChildrenAdded().length, 2);
        h.check(ec.getIndex(), 0);
        ec = this.documentEvent.getChange(par2);
        h.check(ec, null);
    }

    private void testNewlines(TestHarness h) {
        h.checkPoint("testNewlines");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'a'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 1)};
        specs[0].setDirection((short)4);
        doc.insert(0, specs);
        text2 = new char[]{'\n'};
        specs = new DefaultStyledDocument.ElementSpec[3];
        specs[0] = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 1);
        specs[0].setDirection((short)4);
        specs[1] = new DefaultStyledDocument.ElementSpec(atts, 2);
        specs[1].setDirection((short)6);
        specs[2] = new DefaultStyledDocument.ElementSpec(atts, 1);
        specs[2].setDirection((short)7);
        doc.insert(1, specs);
        text2 = new char[]{'a'};
        specs = new DefaultStyledDocument.ElementSpec[3];
        specs[0] = new DefaultStyledDocument.ElementSpec(atts, 2);
        specs[0].setDirection((short)6);
        specs[1] = new DefaultStyledDocument.ElementSpec(atts, 1);
        specs[1].setDirection((short)5);
        specs[2] = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 1);
        specs[2].setDirection((short)6);
        doc.insert(2, specs);
        text2 = new char[]{'\n'};
        specs = new DefaultStyledDocument.ElementSpec[3];
        specs[0] = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 1);
        specs[0].setDirection((short)4);
        specs[1] = new DefaultStyledDocument.ElementSpec(atts, 2);
        specs[1].setDirection((short)6);
        specs[2] = new DefaultStyledDocument.ElementSpec(atts, 1);
        specs[2].setDirection((short)7);
        doc.insert(3, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 3);
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 1);
        Element el = par.getElement(0);
        h.check(el.getStartOffset(), 0);
        h.check(el.getEndOffset(), 2);
        par = root.getElement(1);
        h.check(par.getElementCount(), 1);
        el = par.getElement(0);
        h.check(el.getStartOffset(), 2);
        h.check(el.getEndOffset(), 4);
        par = root.getElement(2);
        h.check(par.getElementCount(), 1);
        el = par.getElement(0);
        h.check(el.getStartOffset(), 4);
        h.check(el.getEndOffset(), 5);
    }

    private void testNewlines2(TestHarness h) {
        h.checkPoint("testNewlines2");
        TestDocument doc = new TestDocument();
        doc.addDocumentListener(this);
        char[] text2 = new char[]{'a'};
        SimpleAttributeSet atts = new SimpleAttributeSet();
        DefaultStyledDocument.ElementSpec[] specs = new DefaultStyledDocument.ElementSpec[]{new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 1)};
        specs[0].setDirection((short)4);
        doc.insert(0, specs);
        text2 = new char[]{'\n'};
        specs = new DefaultStyledDocument.ElementSpec[3];
        specs[0] = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 1);
        specs[0].setDirection((short)4);
        specs[1] = new DefaultStyledDocument.ElementSpec(atts, 2);
        specs[1].setDirection((short)6);
        specs[2] = new DefaultStyledDocument.ElementSpec(atts, 1);
        specs[2].setDirection((short)7);
        doc.insert(1, specs);
        text2 = new char[]{'a'};
        specs = new DefaultStyledDocument.ElementSpec[3];
        specs[0] = new DefaultStyledDocument.ElementSpec(atts, 2);
        specs[0].setDirection((short)6);
        specs[1] = new DefaultStyledDocument.ElementSpec(atts, 1);
        specs[1].setDirection((short)5);
        specs[2] = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 1);
        specs[2].setDirection((short)6);
        doc.insert(2, specs);
        text2 = new char[]{'\n'};
        specs = new DefaultStyledDocument.ElementSpec[3];
        specs[0] = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 1);
        specs[0].setDirection((short)4);
        specs[1] = new DefaultStyledDocument.ElementSpec(atts, 2);
        specs[1].setDirection((short)6);
        specs[2] = new DefaultStyledDocument.ElementSpec(atts, 1);
        specs[2].setDirection((short)7);
        doc.insert(3, specs);
        text2 = new char[]{'a'};
        specs = new DefaultStyledDocument.ElementSpec[3];
        specs[0] = new DefaultStyledDocument.ElementSpec(atts, 2);
        specs[0].setDirection((short)6);
        specs[1] = new DefaultStyledDocument.ElementSpec(atts, 1);
        specs[1].setDirection((short)5);
        specs[2] = new DefaultStyledDocument.ElementSpec(atts, 3, text2, 0, 1);
        specs[2].setDirection((short)6);
        doc.insert(4, specs);
        Element root = doc.getDefaultRootElement();
        h.check(root.getElementCount(), 3);
        Element par = root.getElement(0);
        h.check(par.getElementCount(), 1);
        Element el = par.getElement(0);
        h.check(el.getStartOffset(), 0);
        h.check(el.getEndOffset(), 2);
        par = root.getElement(1);
        h.check(par.getElementCount(), 1);
        el = par.getElement(0);
        h.check(el.getStartOffset(), 2);
        h.check(el.getEndOffset(), 4);
        par = root.getElement(2);
        h.check(par.getElementCount(), 2);
        el = par.getElement(0);
        h.check(el.getStartOffset(), 4);
        h.check(el.getEndOffset(), 5);
        el = par.getElement(1);
        h.check(el.getStartOffset(), 5);
        h.check(el.getEndOffset(), 6);
    }

    @Override
    public void changedUpdate(DocumentEvent event) {
    }

    @Override
    public void insertUpdate(DocumentEvent event) {
        this.documentEvent = event;
    }

    @Override
    public void removeUpdate(DocumentEvent event) {
    }

    static class TestDocument
    extends DefaultStyledDocument {
        TestDocument() {
        }

        @Override
        public void insert(int offset2, DefaultStyledDocument.ElementSpec[] data) {
            try {
                super.insert(offset2, data);
            }
            catch (BadLocationException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

