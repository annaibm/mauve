/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.DefaultStyledDocument.ElementBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.Segment;

public class ElementStructure3
extends DefaultStyledDocument
implements Testlet {
    static TestHarness h2;
    static int numInserts;
    static int numLeaves;
    static int numBranches;

    @Override
    public void test(TestHarness harness) {
        h2 = harness;
        try {
            ElementStructure3 doc = new ElementStructure3();
            doc.insertString(0, "Questions are <font size=\"+1\" color=\"blue\">a burden</font> to others,\nanswers <font size=\"+2\" color=\"red\">a prison</font> for oneself.", null);
        }
        catch (Exception t) {
            harness.debug(t);
        }
        catch (AssertionError e) {
            harness.debug((Throwable)((Object)e));
        }
    }

    public ElementStructure3() {
        this.buffer = new ElementBuffer2((Element)this.createDefaultRoot());
    }

    @Override
    protected void insertUpdate(AbstractDocument.DefaultDocumentEvent ev, AttributeSet attr) {
        int i;
        int newLines = 0;
        h2.check(ev.getLength() == 134);
        h2.check(ev.getOffset() == 0);
        Segment txt = new Segment();
        try {
            this.getText(ev.getOffset(), ev.getLength() + 1, txt);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
        for (i = txt.offset; i < txt.offset + txt.count - 1; ++i) {
            if (txt.array[i] != '\n') continue;
            ++newLines;
        }
        h2.check(newLines == 1);
        h2.check(txt.array[i] == '\n');
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
            super(ElementStructure3.this, root);
        }

        @Override
        protected void insertUpdate(DefaultStyledDocument.ElementSpec[] data) {
            if (++numInserts == 1) {
                h2.checkPoint("ElementBuffer insertUpdate: first insertion");
                h2.check(data.length == 4);
                h2.check(data[0].getType() == 3);
                h2.check(data[0].getDirection() == 4);
                h2.check(data[0].getOffset() == 0);
                h2.check(data[0].getLength() == 70);
                h2.check(data[1].getType() == 2);
                h2.check(data[1].getDirection() == 6);
                h2.check(data[1].getOffset() == 0);
                h2.check(data[1].getLength() == 0);
                h2.check(data[2].getType() == 1);
                h2.check(data[2].getDirection() == 7);
                h2.check(data[2].getOffset() == 0);
                h2.check(data[2].getLength() == 0);
                h2.check(data[3].getType() == 3);
                h2.check(data[3].getDirection() == 5);
                h2.check(data[3].getOffset() == 0);
                h2.check(data[3].getLength() == 64);
            } else {
                h2.fail("too many ElementSpecs created");
            }
            super.insertUpdate(data);
        }
    }
}

