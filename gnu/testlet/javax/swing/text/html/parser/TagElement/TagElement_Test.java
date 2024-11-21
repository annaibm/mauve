/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.html.parser.TagElement;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOException;
import javax.swing.text.html.HTML;
import javax.swing.text.html.parser.DTD;
import javax.swing.text.html.parser.Element;
import javax.swing.text.html.parser.TagElement;

public class TagElement_Test
implements Testlet {
    TestHarness harness;

    @Override
    public void test(TestHarness a_harness) {
        this.harness = a_harness;
        try {
            HTML.Tag[] tags = HTML.getAllTags();
            for (int i = 0; i < tags.length; ++i) {
                HTML.Tag t = tags[i];
                String tn = t.toString();
                Element e = DTD.getDTD("test").getElement("e");
                e.name = tn;
                TagElement te = new TagElement(e, true);
                this.harness.check(te.fictional());
                te = new TagElement(e);
                this.harness.check(!te.fictional());
                this.harness.check(te.getHTMLTag().toString(), (Object)t.toString());
                this.harness.check(t.breaksFlow(), te.breaksFlow());
                this.harness.check(t.isPreformatted(), te.isPreformatted());
            }
        }
        catch (IOException ex) {
            this.harness.fail(ex.getMessage());
        }
    }
}

