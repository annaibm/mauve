/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.AbstractDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;

public class ElementChange
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JTextArea textArea = new JTextArea();
        final TestHarness harness2 = harness;
        ((AbstractDocument)textArea.getDocument()).addDocumentListener(new DocumentListener(){

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                Element root = e.getDocument().getDefaultRootElement();
                DocumentEvent.ElementChange ec = e.getChange(root);
                Element[] childrenAdded = ec.getChildrenAdded();
                Element[] childrenRemoved = ec.getChildrenRemoved();
                harness2.checkPoint("insert update children added");
                harness2.check(childrenAdded.length == 4);
                harness2.check(childrenAdded[0].getStartOffset() == 0);
                harness2.check(childrenAdded[0].getEndOffset() == 36);
                harness2.check(childrenAdded[1].getStartOffset() == 36);
                harness2.check(childrenAdded[1].getEndOffset() == 97);
                harness2.check(childrenAdded[2].getStartOffset() == 97);
                harness2.check(childrenAdded[2].getEndOffset() == 134);
                harness2.check(childrenAdded[3].getStartOffset() == 134);
                harness2.check(childrenAdded[3].getEndOffset() == 176);
                harness2.checkPoint("insert update children removed");
                harness2.check(childrenRemoved.length == 1);
                harness2.check(childrenRemoved[0].getStartOffset() == 0);
                harness2.check(childrenRemoved[0].getEndOffset() == 176);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Element root = e.getDocument().getDefaultRootElement();
                DocumentEvent.ElementChange ec = e.getChange(root);
                Element[] childrenAdded = ec.getChildrenAdded();
                Element[] childrenRemoved = ec.getChildrenRemoved();
                harness2.checkPoint("remove update children added");
                harness2.check(childrenAdded.length == 1);
                harness2.check(childrenAdded[0].getStartOffset() == 0);
                harness2.check(childrenAdded[0].getEndOffset() == 57);
                harness2.checkPoint("remove udpate childrem removed");
                harness2.check(childrenRemoved.length == 2);
                harness2.check(childrenRemoved[0].getStartOffset() == 0);
                harness2.check(childrenRemoved[0].getEndOffset() == 5);
                harness2.check(childrenRemoved[1].getStartOffset() == 5);
                harness2.check(childrenRemoved[1].getEndOffset() == 57);
            }
        });
        textArea.setText("This is the text that we are adding\nIt has several lines, which should be several children added\nWhile only one child will be removed\nThat is, if the implementation is correct");
        try {
            textArea.getDocument().remove(5, 40);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
    }
}

