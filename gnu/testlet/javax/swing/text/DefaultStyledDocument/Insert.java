/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.DefaultStyledDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Insert
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet a1 = new SimpleAttributeSet();
        SimpleAttributeSet a2 = new SimpleAttributeSet();
        a1.addAttribute(StyleConstants.NameAttribute, "MY_FIRST");
        a2.addAttribute(StyleConstants.NameAttribute, "MY_SECOND");
        DefaultStyledDocument.ElementSpec s1 = new DefaultStyledDocument.ElementSpec(a1, 3, "1".toCharArray(), 0, 1);
        DefaultStyledDocument.ElementSpec s2 = new DefaultStyledDocument.ElementSpec(a2, 3, "2".toCharArray(), 0, 1);
        OpenDocument d = new OpenDocument();
        try {
            int i;
            d.insert(0, new DefaultStyledDocument.ElementSpec[]{s1, s2});
            harness.check(d.getLength(), 2, "Length");
            harness.check("12", (Object)d.getText(0, d.getLength()));
            Element[] e = d.getRootElements();
            StringBuffer b = new StringBuffer();
            for (int i2 = 0; i2 < e.length; ++i2) {
                this.dump(b, e[i2]);
            }
            String r = b.toString();
            harness.check(r.indexOf("MY_FIRST:0-1") >= 0);
            harness.check(r.indexOf("MY_SECOND:1-2") >= 0);
            SimpleAttributeSet a3 = new SimpleAttributeSet();
            a1.addAttribute(StyleConstants.NameAttribute, "MY_MIDDLE");
            DefaultStyledDocument.ElementSpec sm = new DefaultStyledDocument.ElementSpec(a1, 3, "m".toCharArray(), 0, 1);
            d.insert(1, new DefaultStyledDocument.ElementSpec[]{sm});
            harness.check(d.getLength(), 3, "Length");
            harness.check("1m2", (Object)d.getText(0, d.getLength()));
            b.setLength(0);
            for (i = 0; i < e.length; ++i) {
                this.dump(b, e[i]);
            }
            r = b.toString();
            harness.check(r.indexOf("MY_FIRST:0-1") >= 0);
            harness.check(r.indexOf("MY_MIDDLE:1-2") >= 0);
            harness.check(r.indexOf("MY_SECOND:2-3") >= 0);
            d.remove(0, 1);
            harness.check("m2", (Object)d.getText(0, d.getLength()));
            b.setLength(0);
            for (i = 0; i < e.length; ++i) {
                this.dump(b, e[i]);
            }
            r = b.toString();
            harness.check(r.indexOf("MY_FIRST") < 0, r);
            harness.check(r.indexOf("MY_MIDDLE:0-1") >= 0, r);
            harness.check(r.indexOf("MY_SECOND:1-2") >= 0, r);
            d.remove(1, 1);
            harness.check("m", (Object)d.getText(0, d.getLength()));
            b.setLength(0);
            for (i = 0; i < e.length; ++i) {
                this.dump(b, e[i]);
            }
            r = b.toString();
            harness.check(r.indexOf("MY_FIRST") < 0, r);
            harness.check(r.indexOf("MY_MIDDLE:0-1") >= 0, r);
            harness.check(r.indexOf("MY_SECOND") < 0, r);
            harness.check(d.getLength(), 1, "Length");
            d.remove(0, d.getLength());
            b.setLength(0);
            for (i = 0; i < e.length; ++i) {
                this.dump(b, e[i]);
            }
            r = b.toString();
            harness.check(r.indexOf("MY_FIRST") < 0, r);
            harness.check(r.indexOf("MY_MIDDLE") < 0, r);
            harness.check(r.indexOf("MY_SECOND") < 0, r);
        }
        catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    }

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
        public void insert(int offset2, DefaultStyledDocument.ElementSpec[] data) throws BadLocationException {
            super.insert(offset2, data);
        }
    }
}

