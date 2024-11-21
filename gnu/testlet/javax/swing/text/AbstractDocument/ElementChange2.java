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

public class ElementChange2
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JTextArea textArea = new JTextArea();
        final TestHarness harness2 = harness;
        textArea.setText("0123456");
        ((AbstractDocument)textArea.getDocument()).addDocumentListener(new DocumentListener(){

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                Element root = e.getDocument().getDefaultRootElement();
                DocumentEvent.ElementChange ec = e.getChange(root);
                harness2.checkPoint("insertUpdate without adding children");
                if (ec != null) {
                    harness2.fail("Element Change should be null");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Element root = e.getDocument().getDefaultRootElement();
                DocumentEvent.ElementChange ec = e.getChange(root);
                harness2.checkPoint("removeUpdate without removing children");
                if (ec != null) {
                    harness2.fail("ElementChange should be null");
                }
            }
        });
        textArea.append("7");
        try {
            textArea.getDocument().remove(3, 1);
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
    }
}

