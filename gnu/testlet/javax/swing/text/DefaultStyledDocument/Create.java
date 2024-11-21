/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.DefaultStyledDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.DefaultStyledDocument.Insert;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Create
extends Insert
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet a1 = new SimpleAttributeSet();
        SimpleAttributeSet a2 = new SimpleAttributeSet();
        SimpleAttributeSet a3 = new SimpleAttributeSet();
        a1.addAttribute(StyleConstants.NameAttribute, "MY_FIRST");
        a2.addAttribute(StyleConstants.NameAttribute, "MY_SECOND");
        a3.addAttribute(StyleConstants.NameAttribute, "MY_MIDDLE");
        DefaultStyledDocument.ElementSpec s1 = new DefaultStyledDocument.ElementSpec(a1, 3, "1".toCharArray(), 0, 1);
        DefaultStyledDocument.ElementSpec s2 = new DefaultStyledDocument.ElementSpec(a2, 3, "2".toCharArray(), 0, 1);
        DefaultStyledDocument.ElementSpec sm = new DefaultStyledDocument.ElementSpec(a3, 3, "m".toCharArray(), 0, 1);
        OpenDocument d = new OpenDocument();
        d.create(new DefaultStyledDocument.ElementSpec[]{s1, sm, s2});
        harness.check(d.getLength(), 3, "Length");
        try {
            harness.check(d.getText(0, d.getLength()), (Object)"1m2");
        }
        catch (BadLocationException e1) {
            throw new RuntimeException(e1);
        }
        Element[] e = d.getRootElements();
        StringBuffer b = new StringBuffer();
        for (int i = 0; i < e.length; ++i) {
            this.dump(b, e[i]);
        }
        String r = b.toString();
        harness.check(r.indexOf("MY_MIDDLE") >= 0, r);
        harness.check(r.indexOf("MY_SECOND") >= 0, r);
    }

    @Override
    void dump(StringBuffer b, Element x) {
        Object name2 = x.getAttributes().getAttribute(StyleConstants.NameAttribute);
        b.append("( ");
        b.append(name2 + ":" + x.getStartOffset() + "-" + x.getEndOffset());
        b.append(" ch ");
        for (int i = 0; i < x.getElementCount(); ++i) {
            this.dump(b, x.getElement(i));
        }
        b.append(") ");
    }

    class OpenDocument
    extends DefaultStyledDocument {
        OpenDocument() {
        }

        @Override
        public void create(DefaultStyledDocument.ElementSpec[] data) {
            super.create(data);
        }
    }
}

