/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.DefaultStyledDocument.ElementBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;

public class ElementStructure1
extends DefaultStyledDocument
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ElementStructure1 doc = new ElementStructure1();
        Element root = doc.getDefaultRootElement();
        try {
            harness.checkPoint("initial setup");
            harness.check(root.getElementCount() == 1);
            harness.check(root.getElement(0).getElementCount() == 1);
            harness.check(root.getElement(0).getElement(0).getElementCount() == 0);
            doc.insertString(0, "the quick brown fox", null);
            harness.checkPoint("after first insertion");
            harness.check(root.getElementCount() == 1);
            harness.check(root.getElement(0).getElementCount() == 1);
            harness.check(root.getElement(0).getElement(0).getElementCount() == 0);
            harness.check(root.getEndOffset() == 20);
            doc.insertString(6, "MIDDLE", null);
            harness.checkPoint("after second insertion");
            harness.check(root.getElementCount() == 1);
            harness.check(root.getElement(0).getElementCount() == 1);
            harness.check(root.getElement(0).getElement(0).getElementCount() == 0);
            harness.check(root.getEndOffset() == 26);
            doc.insertString(0, "START", null);
            harness.checkPoint("after third insertion");
            harness.check(root.getElementCount() == 1);
            harness.check(root.getElement(0).getElementCount() == 1);
            harness.check(root.getElement(0).getElement(0).getElementCount() == 0);
            harness.check(root.getEndOffset() == 31);
            doc.insertString(30, "END", null);
            harness.checkPoint("after fourth insertion");
            harness.check(root.getEndOffset() == 34);
        }
        catch (BadLocationException ex) {
            harness.debug(ex);
        }
        catch (AssertionError ex) {
            harness.debug((Throwable)((Object)ex));
        }
    }
}

