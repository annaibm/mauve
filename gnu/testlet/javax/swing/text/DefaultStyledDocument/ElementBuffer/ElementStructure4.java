/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.DefaultStyledDocument.ElementBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ElementStructure4
extends DefaultStyledDocument
implements Testlet {
    static TestHarness h2;
    static int numInserts;
    static int numLeaves;
    static int numBranches;

    @Override
    public void test(TestHarness harness) {
        try {
            h2 = harness;
            ElementStructure4 doc = new ElementStructure4();
            SimpleAttributeSet atts = new SimpleAttributeSet();
            Element root = doc.getDefaultRootElement();
            atts.addAttribute(StyleConstants.StrikeThrough, Boolean.TRUE);
            doc.insertString(0, "Strike through text.\n", atts);
            atts.removeAttributes(atts);
            harness.checkPoint("after first insertion");
            harness.check(root.getElementCount(), 2);
            harness.check(root.getElement(0).getStartOffset(), 0);
            harness.check(root.getElement(0).getEndOffset(), 21);
            harness.check(root.getElement(1).getStartOffset(), 21);
            harness.check(root.getElement(1).getEndOffset(), 22);
            doc.insertString(0, "a", null);
            harness.checkPoint("after second insertion");
            harness.check(root.getElement(0).getElementCount() == 2);
            harness.check(root.getElement(1).getElementCount() == 1);
            doc.insertString(1, "b", null);
            harness.checkPoint("after second insertion");
            harness.check(root.getElement(0).getElementCount() == 2);
            harness.check(root.getElement(1).getElementCount() == 1);
            harness.checkPoint("final structure");
            Element first2 = root.getElement(0).getElement(0);
            harness.check(first2.getStartOffset() == 0);
            harness.check(first2.getEndOffset() == 2);
            Element second = root.getElement(0).getElement(1);
            harness.check(second.getStartOffset() == 2);
            harness.check(second.getEndOffset() == 23);
        }
        catch (Exception t) {
            harness.debug(t);
        }
        catch (AssertionError e) {
            harness.debug((Throwable)((Object)e));
        }
    }

    public ElementStructure4() {
        this.buffer = new ElementBuffer2((Element)this.createDefaultRoot());
    }

    @Override
    protected void insertUpdate(AbstractDocument.DefaultDocumentEvent ev, AttributeSet attr) {
        int l = ev.getLength();
        int o = ev.getOffset();
        if (numInserts == 0) {
            h2.checkPoint("first doc event");
            h2.check(o == 0);
            h2.check(l == 21);
        } else if (numInserts == 1) {
            h2.checkPoint("second doc event");
            h2.check(o == 0);
            h2.check(l == 1);
        } else if (numInserts == 2) {
            h2.checkPoint("third doc event");
            h2.check(o == 1);
            h2.check(l == 1);
        } else {
            h2.fail("too many calls to DefaultStyledDocument.insertUpdate");
        }
        super.insertUpdate(ev, attr);
    }

    static {
        numInserts = 0;
        numLeaves = 0;
        numBranches = 0;
    }

    public class ElementBuffer2
    extends DefaultStyledDocument.ElementBuffer {
        public ElementBuffer2(Element root) {
            super(ElementStructure4.this, root);
        }

        @Override
        protected void insertUpdate(DefaultStyledDocument.ElementSpec[] data) {
            if (++numInserts == 1) {
                h2.checkPoint("ElementBuffer insertUpdate: first insertion");
                h2.check(data.length == 3);
                h2.check(data[0].getType() == 3);
                h2.check(data[0].getDirection() == 6);
                h2.check(data[0].getOffset() == 0);
                h2.check(data[0].getLength() == 21);
                h2.check(data[1].getType() == 2);
                h2.check(data[1].getDirection() == 6);
                h2.check(data[1].getOffset() == 0);
                h2.check(data[1].getLength() == 0);
                h2.check(data[2].getType() == 1);
                h2.check(data[2].getDirection() == 7);
                h2.check(data[2].getOffset() == 0);
                h2.check(data[2].getLength() == 0);
            } else if (numInserts == 2) {
                h2.checkPoint("ElementBuffer insertUpdate: second insertion");
                h2.check(data.length == 1);
                h2.check(data[0].getType() == 3);
                h2.check(data[0].getDirection() == 6);
                h2.check(data[0].getOffset() == 0);
                h2.check(data[0].getLength() == 1);
            } else if (numInserts == 3) {
                h2.checkPoint("ElementBuffer insertUpdate: third insertion");
                h2.check(data.length == 1);
                h2.check(data[0].getType() == 3);
                h2.check(data[0].getDirection() == 4);
                h2.check(data[0].getOffset() == 0);
                h2.check(data[0].getLength() == 1);
            } else {
                h2.fail("too many ElementSpecs created");
            }
            super.insertUpdate(data);
        }
    }
}

