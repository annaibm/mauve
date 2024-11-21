/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.parser.DTD;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.parser.DTD;
import javax.swing.text.html.parser.Element;

public class DTD_test
implements Testlet {
    TestHarness harness;

    @Override
    public void test(TestHarness a_harness) {
        this.harness = a_harness;
        D d = new D();
        HTML.Tag[] tags = HTML.getAllTags();
        Element prehead = d.createElement("head");
        for (int i = 0; i < tags.length; ++i) {
            Element e = d.createElement(tags[i].toString());
            String name2 = tags[i].toString();
            this.harness.check(e != null, "Element creation");
            this.harness.check(e.getName().equalsIgnoreCase(name2), "Element name");
        }
        Element e = d.createElement("head");
        this.harness.check(e != null, "Element creation");
        this.harness.check(e.getName().equalsIgnoreCase("head"), "Element name");
        this.harness.check(HTML.Tag.HEAD, HTML.getTag(e.name));
        this.harness.check(d.head, e, "Field assignment");
        this.harness.check(prehead, e);
    }

    static class D
    extends DTD {
        public D() {
            super("test");
        }

        public Element createElement(String n) {
            return this.getElement(n);
        }
    }
}

