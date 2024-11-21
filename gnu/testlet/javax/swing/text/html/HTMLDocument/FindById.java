/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.HTMLDocument;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTextPane;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;

public class FindById
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JTextPane html = new JTextPane();
        html.setContentType("text/html");
        html.setText("<p id = myOne>my text<i><b id = myTwo>myBold</b></i>xxx");
        HTMLDocument doc = (HTMLDocument)html.getDocument();
        Element el = doc.getElement("myOne");
        harness.check(true, el != null, "p with id must be found");
        harness.check(el.getAttributes().getAttribute(StyleConstants.NameAttribute), HTML.Tag.P, "Type must match");
        harness.check(!el.isLeaf());
        el = doc.getElement("myNone");
        harness.check(el == null, "should not be found");
    }
}

