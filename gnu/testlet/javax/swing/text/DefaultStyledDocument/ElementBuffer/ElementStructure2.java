/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.DefaultStyledDocument.ElementBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;

public class ElementStructure2
extends DefaultStyledDocument
implements Testlet {
    static TestHarness h2;

    public ElementStructure2() {
        this.buffer = new ElementBuffer2((Element)this.createDefaultRoot());
    }

    @Override
    public void test(TestHarness harness) {
        h2 = harness;
        ElementStructure2 doc = new ElementStructure2();
        Element root = doc.getDefaultRootElement();
        try {
            doc.insertString(0, "the quick brown fox", null);
            doc.insertString(6, "MIDDLE", null);
            doc.insertString(0, "START", null);
            doc.insertString(30, "END", null);
        }
        catch (BadLocationException ex) {
            harness.debug(ex);
        }
    }

    public class ElementBuffer2
    extends DefaultStyledDocument.ElementBuffer {
        public ElementBuffer2(Element root) {
            super(ElementStructure2.this, root);
        }

        @Override
        protected void insertUpdate(DefaultStyledDocument.ElementSpec[] data) {
            for (int i = 0; i < data.length; ++i) {
                h2.check(data[i].getDirection() == 4);
            }
            super.insertUpdate(data);
        }
    }
}

