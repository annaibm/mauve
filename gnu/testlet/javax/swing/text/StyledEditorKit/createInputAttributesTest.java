/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyledEditorKit;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.html.HTMLDocument;

public class createInputAttributesTest
extends StyledEditorKit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet mas = new SimpleAttributeSet();
        mas.addAttribute("A", "B");
        HTMLDocument h = new HTMLDocument();
        Element e = h.getDefaultRootElement();
        this.createInputAttributes(e, mas);
        harness.check(mas.getAttribute("A") == null);
    }
}

