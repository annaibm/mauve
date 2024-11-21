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

public class StyledDocument4
extends DefaultStyledDocument
implements Testlet {
    static int numInserts = 0;
    static TestHarness h2;
    static int numLeaves;
    static int numBranches;

    @Override
    public void test(TestHarness harness) {
        h2 = harness;
        StyledDocument4 doc = new StyledDocument4();
        try {
            doc.insertString(0, "aaaaaaaaa\nbbbbbbbbb", null);
            doc.insertString(5, "\nN", null);
        }
        catch (Exception ex) {
            harness.debug(ex);
        }
        catch (AssertionError e) {
            harness.debug((Throwable)((Object)e));
        }
    }

    public StyledDocument4() {
        this.buffer = new ElementBuffer2((Element)this.createDefaultRoot());
    }

    @Override
    protected void insertUpdate(AbstractDocument.DefaultDocumentEvent ev, AttributeSet attr) {
        int l = ev.getLength();
        int o = ev.getOffset();
        if (numInserts == 0) {
            h2.checkPoint("first doc event");
            h2.check(o == 0);
            h2.check(l == 19);
        } else if (numInserts == 1) {
            h2.checkPoint("second doc event");
            h2.check(o == 5);
            h2.check(l == 2);
        } else {
            h2.fail("too many calls to DefaultStyledDocument.insertUpdate");
        }
        super.insertUpdate(ev, attr);
    }

    static {
        numLeaves = 0;
        numBranches = 0;
    }

    public class ElementBuffer2
    extends DefaultStyledDocument.ElementBuffer {
        public ElementBuffer2(Element root) {
            super(StyledDocument4.this, root);
        }

        @Override
        protected void insertUpdate(DefaultStyledDocument.ElementSpec[] data) {
            if (++numInserts == 1) {
                h2.check(data[0].getType() == 3);
                h2.check(data[0].getDirection() == 4);
                h2.check(data[0].getOffset() == 0);
                h2.check(data[0].getLength() == 10);
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
                h2.check(data[3].getLength() == 9);
            } else if (numInserts == 2) {
                h2.check(data[0].getType() == 3);
                h2.check(data[0].getDirection() == 4);
                h2.check(data[0].getOffset() == 0);
                h2.check(data[0].getLength() == 1);
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
                h2.check(data[3].getLength() == 1);
            }
            super.insertUpdate(data);
        }
    }
}

