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

public class ElementStructure5
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
            ElementStructure5 doc = new ElementStructure5();
            Element root = doc.getDefaultRootElement();
            doc.insertString(0, "first line of text. \n", null);
            harness.check(root.getElementCount() == 2);
            harness.check(root.getElement(0).getStartOffset() == 0);
            harness.check(root.getElement(0).getEndOffset() == 21);
            harness.check(root.getElement(1).getStartOffset() == 21);
            harness.check(root.getElement(1).getEndOffset() == 22);
            doc.insertString(21, "second line of text. \n", null);
            harness.check(root.getElementCount() == 3);
            harness.check(root.getElement(0).getElementCount() == 1);
            harness.check(root.getElement(1).getElementCount() == 1);
            harness.check(root.getElement(2).getElementCount() == 1);
            Element first2 = root.getElement(0).getElement(0);
            harness.check(first2.getStartOffset() == 0);
            harness.check(first2.getEndOffset() == 21);
            Element second = root.getElement(1).getElement(0);
            harness.check(second.getStartOffset() == 21);
            harness.check(second.getEndOffset() == 43);
            Element third = root.getElement(2).getElement(0);
            harness.check(third.getStartOffset() == 43);
            harness.check(third.getEndOffset() == 44);
        }
        catch (Exception t) {
            harness.debug(t);
        }
        catch (AssertionError e) {
            harness.debug((Throwable)((Object)e));
        }
    }

    public ElementStructure5() {
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
            h2.check(o == 21);
            h2.check(l == 22);
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
            super(ElementStructure5.this, root);
        }

        @Override
        protected void insertUpdate(DefaultStyledDocument.ElementSpec[] data) {
            if (++numInserts == 1) {
                h2.checkPoint("ElementBuffer insertUpdate: first insertion");
                h2.check(data.length == 3);
                h2.check(data[0].getType() == 3);
                h2.check(data[0].getDirection() == 4);
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
                h2.check(data.length == 5);
                h2.check(data[0].getType() == 2);
                h2.check(data[0].getDirection() == 6);
                h2.check(data[0].getOffset() == 0);
                h2.check(data[0].getLength() == 0);
                h2.check(data[1].getType() == 1);
                h2.check(data[1].getDirection() == 6);
                h2.check(data[1].getOffset() == 0);
                h2.check(data[1].getLength() == 0);
                h2.check(data[2].getType() == 3);
                h2.check(data[2].getDirection() == 6);
                h2.check(data[2].getOffset() == 0);
                h2.check(data[2].getLength() == 22);
                h2.check(data[3].getType() == 2);
                h2.check(data[3].getDirection() == 6);
                h2.check(data[3].getOffset() == 0);
                h2.check(data[3].getLength() == 0);
                h2.check(data[4].getType() == 1);
                h2.check(data[4].getDirection() == 5);
                h2.check(data[4].getOffset() == 0);
                h2.check(data[4].getLength() == 0);
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

