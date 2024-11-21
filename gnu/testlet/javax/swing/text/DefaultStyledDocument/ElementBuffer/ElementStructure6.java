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

public class ElementStructure6
extends DefaultStyledDocument
implements Testlet {
    static TestHarness h2;
    static AbstractDocument.DefaultDocumentEvent docEvent;
    static int numInserts;
    static int numLeaves;
    static int numBranches;

    @Override
    public void test(TestHarness harness) {
        ElementStructure6 doc = new ElementStructure6();
        try {
            h2 = harness;
            doc.insertString(0, "First line of text. \n", null);
        }
        catch (Exception ex) {
            h2.debug(ex);
        }
        catch (AssertionError e) {
            harness.debug((Throwable)((Object)e));
        }
    }

    public ElementStructure6() {
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
        } else {
            h2.fail("too many calls to DefaultStyledDocument.insertUpdate");
        }
        docEvent = ev;
        h2.check(docEvent.getChange(this.getDefaultRootElement()) == null);
        super.insertUpdate(ev, attr);
        h2.check(docEvent.getChange(this.getDefaultRootElement()) != null);
    }

    static {
        docEvent = null;
        numInserts = 0;
        numLeaves = 0;
        numBranches = 0;
    }

    public class ElementBuffer2
    extends DefaultStyledDocument.ElementBuffer {
        public ElementBuffer2(Element root) {
            super(ElementStructure6.this, root);
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
            h2.check(docEvent.getChange(ElementStructure6.this.getDefaultRootElement()) == null);
            super.insertUpdate(data);
            h2.check(docEvent.getChange(ElementStructure6.this.getDefaultRootElement()) == null);
        }

        @Override
        public void insert(int offset2, int length2, DefaultStyledDocument.ElementSpec[] data, AbstractDocument.DefaultDocumentEvent de) {
            h2.check(docEvent.getChange(ElementStructure6.this.getDefaultRootElement()) == null);
            super.insert(offset2, length2, data, de);
            h2.check(docEvent.getChange(ElementStructure6.this.getDefaultRootElement()) != null);
        }
    }
}

