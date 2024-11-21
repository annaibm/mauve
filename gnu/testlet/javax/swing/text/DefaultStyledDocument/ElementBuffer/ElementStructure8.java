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

public class ElementStructure8
extends DefaultStyledDocument
implements Testlet {
    static TestHarness h2;
    static int numInserts;

    @Override
    public void test(TestHarness harness) {
        h2 = harness;
        try {
            harness.checkPoint("Test 0");
            ElementStructure8 doc = new ElementStructure8();
            Element root = doc.getDefaultRootElement();
            doc.insertString(0, "first line of text. \n", null);
            harness.check(root.getElementCount() == 2);
            harness.check(root.getElement(0).getStartOffset() == 0);
            harness.check(root.getElement(0).getEndOffset() == 21);
            harness.check(root.getElement(1).getStartOffset() == 21);
            harness.check(root.getElement(1).getEndOffset() == 22);
            doc.insertString(21, "second line of text. \n third line of text. \n", null);
            harness.check(root.getElementCount() == 4);
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
            harness.check(third.getEndOffset() == 65);
            Element fourth = root.getElement(3).getElement(0);
            harness.check(fourth.getStartOffset() == 65);
            harness.check(fourth.getEndOffset() == 66);
            harness.checkPoint("Test 1");
            doc = new ElementStructure8();
            root = doc.getDefaultRootElement();
            doc.insertString(0, "first line of text. \n", null);
            harness.check(root.getElementCount() == 2);
            harness.check(root.getElement(0).getStartOffset() == 0);
            harness.check(root.getElement(0).getEndOffset() == 21);
            harness.check(root.getElement(1).getStartOffset() == 21);
            harness.check(root.getElement(1).getEndOffset() == 22);
            doc.insertString(21, "second line of text. \n ", null);
            harness.check(root.getElementCount() == 3);
            harness.check(root.getElement(0).getElementCount() == 1);
            harness.check(root.getElement(1).getElementCount() == 1);
            harness.check(root.getElement(2).getElementCount() == 2);
            first2 = root.getElement(0).getElement(0);
            harness.check(first2.getStartOffset() == 0);
            harness.check(first2.getEndOffset() == 21);
            second = root.getElement(1).getElement(0);
            harness.check(second.getStartOffset() == 21);
            harness.check(second.getEndOffset() == 43);
            third = root.getElement(2).getElement(0);
            harness.check(third.getStartOffset() == 43);
            harness.check(third.getEndOffset() == 44);
            fourth = root.getElement(2).getElement(1);
            harness.check(fourth.getStartOffset() == 44);
            harness.check(fourth.getEndOffset() == 45);
            harness.checkPoint("Test 2");
            doc = new ElementStructure8();
            root = doc.getDefaultRootElement();
            doc.insertString(0, "first line of text.", null);
            harness.check(root.getElementCount() == 1);
            harness.check(root.getElement(0).getStartOffset() == 0);
            harness.check(root.getElement(0).getEndOffset() == 20);
            doc.insertString(5, "second line \n of text.", null);
            harness.check(root.getElementCount() == 2);
            harness.check(root.getElement(0).getElementCount() == 1);
            harness.check(root.getElement(1).getElementCount() == 1);
            first2 = root.getElement(0).getElement(0);
            harness.check(first2.getStartOffset() == 0);
            harness.check(first2.getEndOffset() == 18);
            second = root.getElement(1).getElement(0);
            harness.check(second.getStartOffset() == 18);
            harness.check(second.getEndOffset() == 42);
            harness.checkPoint("Test 3");
            doc = new ElementStructure8();
            root = doc.getDefaultRootElement();
            doc.insertString(0, "first line of text. \n", null);
            harness.check(root.getElementCount() == 2);
            harness.check(root.getElement(0).getStartOffset() == 0);
            harness.check(root.getElement(0).getEndOffset() == 21);
            harness.check(root.getElement(1).getStartOffset() == 21);
            harness.check(root.getElement(1).getEndOffset() == 22);
            doc.insertString(21, "\n second line of text. \n third line of text. \n", null);
            harness.check(root.getElementCount() == 5);
            harness.check(root.getElement(0).getElementCount() == 1);
            harness.check(root.getElement(1).getElementCount() == 1);
            harness.check(root.getElement(2).getElementCount() == 1);
            harness.check(root.getElement(3).getElementCount() == 1);
            first2 = root.getElement(0).getElement(0);
            harness.check(first2.getStartOffset() == 0);
            harness.check(first2.getEndOffset() == 21);
            second = root.getElement(1).getElement(0);
            harness.check(second.getStartOffset() == 21);
            harness.check(second.getEndOffset() == 22);
            third = root.getElement(2).getElement(0);
            harness.check(third.getStartOffset() == 22);
            harness.check(third.getEndOffset() == 45);
            fourth = root.getElement(3).getElement(0);
            harness.check(fourth.getStartOffset() == 45);
            harness.check(fourth.getEndOffset() == 67);
            Element fifth = root.getElement(4).getElement(0);
            harness.check(fifth.getStartOffset() == 67);
            harness.check(fifth.getEndOffset() == 68);
            harness.checkPoint("Test 4");
            doc = new ElementStructure8();
            root = doc.getDefaultRootElement();
            doc.insertString(0, "\n second line of text. \n third line of text. \n", null);
            harness.check(root.getElementCount() == 4);
            harness.check(root.getElement(0).getElementCount() == 1);
            harness.check(root.getElement(1).getElementCount() == 1);
            harness.check(root.getElement(2).getElementCount() == 1);
            harness.check(root.getElement(3).getElementCount() == 1);
            first2 = root.getElement(0).getElement(0);
            harness.check(first2.getStartOffset() == 0);
            harness.check(first2.getEndOffset() == 1);
            second = root.getElement(1).getElement(0);
            harness.check(second.getStartOffset() == 1);
            harness.check(second.getEndOffset() == 24);
            third = root.getElement(2).getElement(0);
            harness.check(third.getStartOffset() == 24);
            harness.check(third.getEndOffset() == 46);
            fourth = root.getElement(3).getElement(0);
            harness.check(fourth.getStartOffset() == 46);
            harness.check(fourth.getEndOffset() == 47);
            harness.checkPoint("Test 5");
            doc = new ElementStructure8();
            root = doc.getDefaultRootElement();
            doc.insertString(0, "first line of text.", null);
            harness.check(root.getElementCount() == 1);
            harness.check(root.getElement(0).getStartOffset() == 0);
            harness.check(root.getElement(0).getEndOffset() == 20);
            doc.insertString(19, "\n third line of text.", null);
            harness.check(root.getElementCount(), 2);
            harness.check(root.getElement(0).getElementCount(), 1);
            harness.check(root.getElement(1).getElementCount(), 1);
            first2 = root.getElement(0).getElement(0);
            harness.check(first2.getStartOffset(), 0);
            harness.check(first2.getEndOffset(), 20);
            second = root.getElement(1).getElement(0);
            harness.check(second.getStartOffset(), 20);
            harness.check(second.getEndOffset(), 41);
        }
        catch (Exception t) {
            t.printStackTrace();
            harness.debug(t);
        }
        catch (AssertionError e) {
            ((Throwable)((Object)e)).printStackTrace();
            harness.debug((Throwable)((Object)e));
        }
    }

    public ElementStructure8() {
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
            h2.check(l == 44);
        } else if (numInserts == 2) {
            h2.checkPoint("third doc event");
            h2.check(o == 0);
            h2.check(l == 21);
        } else if (numInserts == 3) {
            h2.checkPoint("fourth doc event");
            h2.check(o == 21);
            h2.check(l == 23);
        } else if (numInserts == 4) {
            h2.checkPoint("fifth doc event");
            h2.check(o == 0);
            h2.check(l == 19);
        } else if (numInserts == 5) {
            h2.checkPoint("sixth doc event");
            h2.check(o == 5);
            h2.check(l == 22);
        } else if (numInserts == 6) {
            h2.checkPoint("seventh doc event");
            h2.check(o == 0);
            h2.check(l == 21);
        } else if (numInserts == 7) {
            h2.checkPoint("eighth doc event");
            h2.check(o == 21);
            h2.check(l == 46);
        } else if (numInserts == 8) {
            h2.checkPoint("ninth doc event");
            h2.check(o == 0);
            h2.check(l == 46);
        } else if (numInserts == 9) {
            h2.checkPoint("tenth doc event");
            h2.check(o == 0);
            h2.check(l == 19);
        } else if (numInserts == 10) {
            h2.checkPoint("eleventh doc event");
            h2.check(o, 19);
            h2.check(l, 21);
        } else {
            h2.fail("too many calls to DefaultStyledDocument.insertUpdate");
        }
        super.insertUpdate(ev, attr);
    }

    static {
        numInserts = 0;
    }

    public class ElementBuffer2
    extends DefaultStyledDocument.ElementBuffer {
        public ElementBuffer2(Element root) {
            super(ElementStructure8.this, root);
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
                h2.check(data.length == 8);
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
                h2.check(data[4].getDirection() == 6);
                h2.check(data[4].getOffset() == 0);
                h2.check(data[4].getLength() == 0);
                h2.check(data[5].getType() == 3);
                h2.check(data[5].getDirection() == 6);
                h2.check(data[5].getOffset() == 0);
                h2.check(data[5].getLength() == 22);
                h2.check(data[6].getType() == 2);
                h2.check(data[6].getDirection() == 6);
                h2.check(data[6].getOffset() == 0);
                h2.check(data[6].getLength() == 0);
                h2.check(data[7].getType() == 1);
                h2.check(data[7].getDirection() == 5);
                h2.check(data[7].getOffset() == 0);
                h2.check(data[7].getLength() == 0);
            } else if (numInserts == 3) {
                h2.checkPoint("ElementBuffer insertUpdate: third insertion");
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
            } else if (numInserts == 4) {
                h2.checkPoint("ElementBuffer insertUpdate: fourth insertion");
                h2.check(data.length == 6);
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
                h2.check(data[5].getType() == 3);
                h2.check(data[5].getDirection() == 6);
                h2.check(data[5].getOffset() == 0);
                h2.check(data[5].getLength() == 1);
            } else if (numInserts == 5) {
                h2.checkPoint("ElementBuffer insertUpdate: fifth insertion");
                h2.check(data.length == 1);
                h2.check(data[0].getType() == 3);
                h2.check(data[0].getDirection() == 4);
                h2.check(data[0].getOffset() == 0);
                h2.check(data[0].getLength() == 19);
            } else if (numInserts == 6) {
                h2.checkPoint("ElementBuffer insertUpdate: sixth insertion");
                h2.check(data.length == 4);
                h2.check(data[0].getType() == 3);
                h2.check(data[0].getDirection() == 4);
                h2.check(data[0].getOffset() == 0);
                h2.check(data[0].getLength() == 13);
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
            } else if (numInserts == 7) {
                h2.checkPoint("ElementBuffer insertUpdate: seventh insertion");
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
            } else if (numInserts == 8) {
                h2.checkPoint("ElementBuffer insertUpdate: second insertion");
                h2.check(data.length == 11);
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
                h2.check(data[2].getLength() == 1);
                h2.check(data[3].getType() == 2);
                h2.check(data[3].getDirection() == 6);
                h2.check(data[3].getOffset() == 0);
                h2.check(data[3].getLength() == 0);
                h2.check(data[4].getType() == 1);
                h2.check(data[4].getDirection() == 6);
                h2.check(data[4].getOffset() == 0);
                h2.check(data[4].getLength() == 0);
                h2.check(data[5].getType() == 3);
                h2.check(data[5].getDirection() == 6);
                h2.check(data[5].getOffset() == 0);
                h2.check(data[5].getLength() == 23);
                h2.check(data[6].getType() == 2);
                h2.check(data[6].getDirection() == 6);
                h2.check(data[6].getOffset() == 0);
                h2.check(data[6].getLength() == 0);
                h2.check(data[7].getType() == 1);
                h2.check(data[7].getDirection() == 6);
                h2.check(data[7].getOffset() == 0);
                h2.check(data[7].getLength() == 0);
                h2.check(data[8].getType() == 3);
                h2.check(data[8].getDirection() == 6);
                h2.check(data[8].getOffset() == 0);
                h2.check(data[8].getLength() == 22);
                h2.check(data[9].getType() == 2);
                h2.check(data[9].getDirection() == 6);
                h2.check(data[9].getOffset() == 0);
                h2.check(data[9].getLength() == 0);
                h2.check(data[10].getType() == 1);
                h2.check(data[10].getDirection() == 5);
                h2.check(data[10].getOffset() == 0);
                h2.check(data[10].getLength() == 0);
            } else if (numInserts == 9) {
                h2.checkPoint("ElementBuffer insertUpdate: second insertion");
                h2.check(data.length == 9);
                h2.check(data[0].getType() == 3);
                h2.check(data[0].getDirection() == 4);
                h2.check(data[0].getOffset() == 0);
                h2.check(data[0].getLength() == 1);
                h2.check(data[1].getType() == 2);
                h2.check(data[1].getDirection() == 6);
                h2.check(data[1].getOffset() == 0);
                h2.check(data[1].getLength() == 0);
                h2.check(data[2].getType() == 1);
                h2.check(data[2].getDirection() == 6);
                h2.check(data[2].getOffset() == 0);
                h2.check(data[2].getLength() == 0);
                h2.check(data[3].getType() == 3);
                h2.check(data[3].getDirection() == 6);
                h2.check(data[3].getOffset() == 0);
                h2.check(data[3].getLength() == 23);
                h2.check(data[4].getType() == 2);
                h2.check(data[4].getDirection() == 6);
                h2.check(data[4].getOffset() == 0);
                h2.check(data[4].getLength() == 0);
                h2.check(data[5].getType() == 1);
                h2.check(data[5].getDirection() == 6);
                h2.check(data[5].getOffset() == 0);
                h2.check(data[5].getLength() == 0);
                h2.check(data[6].getType() == 3);
                h2.check(data[6].getDirection() == 6);
                h2.check(data[6].getOffset() == 0);
                h2.check(data[6].getLength() == 22);
                h2.check(data[7].getType() == 2);
                h2.check(data[7].getDirection() == 6);
                h2.check(data[7].getOffset() == 0);
                h2.check(data[7].getLength() == 0);
                h2.check(data[8].getType() == 1);
                h2.check(data[8].getDirection() == 7);
                h2.check(data[8].getOffset() == 0);
                h2.check(data[8].getLength() == 0);
            } else if (numInserts == 10) {
                h2.checkPoint("ElementBuffer insertUpdate: tenth insertion");
                h2.check(data.length == 1);
                h2.check(data[0].getType() == 3);
                h2.check(data[0].getDirection() == 4);
                h2.check(data[0].getOffset() == 0);
                h2.check(data[0].getLength() == 19);
            } else if (numInserts == 11) {
                h2.checkPoint("ElementBuffer insertUpdate: eleventh insertion");
                h2.check(data.length, 4);
                h2.check(data[0].getType(), 3);
                h2.check(data[0].getDirection(), 4);
                h2.check(data[0].getOffset(), 0);
                h2.check(data[0].getLength(), 1);
                h2.check(data[1].getType(), 2);
                h2.check(data[1].getDirection(), 6);
                h2.check(data[1].getOffset(), 0);
                h2.check(data[1].getLength(), 0);
                h2.check(data[2].getType(), 1);
                h2.check(data[2].getDirection(), 7);
                h2.check(data[2].getOffset(), 0);
                h2.check(data[2].getLength(), 0);
                h2.check(data[3].getType(), 3);
                h2.check(data[3].getDirection(), 5);
                h2.check(data[3].getOffset(), 0);
                h2.check(data[3].getLength(), 20);
            } else {
                h2.fail("too many ElementSpecs created");
            }
            super.insertUpdate(data);
        }
    }
}

