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
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class StyledDocument2
extends DefaultStyledDocument
implements Testlet {
    static int numInserts = 0;
    static TestHarness h2;
    static int numLeaves;
    static int numBranches;

    @Override
    public void test(TestHarness harness) {
        h2 = harness;
        StyledDocument2 doc = new StyledDocument2();
        SimpleAttributeSet atts = new SimpleAttributeSet();
        try {
            atts.addAttribute(StyleConstants.StrikeThrough, Boolean.TRUE);
            doc.insertString(0, "bbbbb", atts);
            doc.insertString(5, "aaaaa", null);
        }
        catch (Exception ex) {
            harness.debug(ex);
        }
        catch (AssertionError e) {
            harness.debug((Throwable)((Object)e));
        }
    }

    public StyledDocument2() {
        this.buffer = new ElementBuffer2((Element)this.createDefaultRoot());
    }

    @Override
    protected void insertUpdate(AbstractDocument.DefaultDocumentEvent ev, AttributeSet attr) {
        int l = ev.getLength();
        int o = ev.getOffset();
        if (numInserts == 0) {
            h2.checkPoint("first doc event");
            h2.check(o == 0);
            h2.check(l == 5);
        } else if (numInserts == 1) {
            h2.checkPoint("second doc event");
            h2.check(o == 5);
            h2.check(l == 5);
        } else {
            h2.fail("too many calls to DefaultStyledDocument.insertUpdate");
        }
        super.insertUpdate(ev, attr);
        h2.check(this.getDefaultRootElement().getElement(0).getElementCount() == numInserts + 1);
    }

    @Override
    protected Element createLeafElement(Element parent, AttributeSet a, int p0, int p1) {
        if (++numLeaves == 1) {
            h2.checkPoint("create first leaf element");
            h2.check(p0, 0);
            h2.check(p1, 5);
            try {
                h2.check(parent.getStartOffset(), 0);
                h2.check(parent.getEndOffset(), 6);
            }
            catch (Exception e) {
                h2.fail("parent Element should have children, but has none.");
                h2.fail("parent Element should have children, but has none.");
            }
            h2.check(a.getAttribute(StyleConstants.StrikeThrough) == Boolean.TRUE);
        } else if (numLeaves == 2) {
            h2.checkPoint("create second leaf element");
            h2.check(p0 == 5);
            h2.check(p1 == 6);
            try {
                h2.check(parent.getStartOffset() == 0);
                h2.check(parent.getEndOffset() == 6);
            }
            catch (Exception e) {
                h2.fail("parent Element should have children, but has none.");
                h2.fail("parent Element should have children, but has none.");
            }
            h2.check(a.getAttributeCount() == 0);
        } else if (numLeaves == 3) {
            h2.checkPoint("create third leaf element");
            h2.check(p0 == 0);
            h2.check(p1 == 5);
            try {
                h2.check(parent.getStartOffset() == 0);
                h2.check(parent.getEndOffset() == 11);
            }
            catch (Exception e) {
                h2.fail("branch element should have children, but has none");
                h2.fail("branch element should have children, but has none");
            }
            h2.check(a.getAttribute(StyleConstants.StrikeThrough) == Boolean.TRUE);
        } else if (numLeaves == 4) {
            h2.checkPoint("create fourth leaf element");
            h2.check(p0 == 5);
            h2.check(p1 == 10);
            try {
                h2.check(parent.getStartOffset() == 0);
                h2.check(parent.getEndOffset() == 11);
            }
            catch (Exception e) {
                h2.fail("branch element should have children, but has none");
                h2.fail("branch element should have children, but has none");
            }
            h2.check(a.getAttributeCount() == 0);
        } else {
            h2.fail("too many leaf elements created");
        }
        return super.createLeafElement(parent, a, p0, p1);
    }

    @Override
    protected Element createBranchElement(Element parent, AttributeSet a) {
        ++numBranches;
        h2.fail("too many branch elements created");
        return super.createBranchElement(parent, a);
    }

    public static void pad(int pad) {
        for (int i = 0; i < pad; ++i) {
            System.out.print(" ");
        }
    }

    public static void printElements(Element start, int pad) {
        StyledDocument2.pad(pad);
        if (pad == 0) {
            System.out.println("ROOT ELEMENT (" + start.getStartOffset() + ", " + start.getEndOffset() + ")");
        } else if (start instanceof AbstractDocument.BranchElement) {
            System.out.println("BranchElement (" + start.getStartOffset() + ", " + start.getEndOffset() + ")");
        } else {
            try {
                System.out.println("LeafElement (" + start.getStartOffset() + ", " + start.getEndOffset() + "): " + start.getAttributes().getAttributeCount() + ": " + start.getDocument().getText(start.getStartOffset(), start.getEndOffset() - start.getStartOffset()));
            }
            catch (BadLocationException badLocationException) {
                // empty catch block
            }
        }
        for (int i = 0; i < start.getElementCount(); ++i) {
            StyledDocument2.printElements(start.getElement(i), pad + 3);
        }
    }

    static {
        numLeaves = 0;
        numBranches = 0;
    }

    public class ElementBuffer2
    extends DefaultStyledDocument.ElementBuffer {
        public ElementBuffer2(Element root) {
            super(StyledDocument2.this, root);
        }

        @Override
        protected void insertUpdate(DefaultStyledDocument.ElementSpec[] data) {
            if (++numInserts == 1) {
                h2.check(data[0].getType() == 3);
                h2.check(data[0].getDirection() == 6);
                h2.check(data[0].getOffset() == 0);
                h2.check(data[0].getLength() == 5);
            } else if (numInserts == 2) {
                h2.check(data[0].getType() == 3);
                h2.check(data[0].getDirection() == 6);
                h2.check(data[0].getOffset() == 0);
                h2.check(data[0].getLength() == 5);
            } else {
                h2.fail("too many ElementSpecs created");
            }
            super.insertUpdate(data);
        }
    }
}

